

function getFullPath(obj) 
{ 
	var mozilla = /firefox/.test(navigator.userAgent.toLowerCase()),
	webkit = /webkit/.test(navigator.userAgent.toLowerCase()),
	opera = /opera/.test(navigator.userAgent.toLowerCase()),
	msie = /msie/.test(navigator.userAgent.toLowerCase()),
	safari = /safari/.test(navigator.userAgent.toLowerCase());
	
	if(obj) 
	{ 
		//ie 
		if (window.navigator.userAgent.indexOf("MSIE")>=1) 
		{ 
			obj.select(); 
			return document.selection.createRange().text; 
		} 
		//firefox 
		else if(window.navigator.userAgent.indexOf("Firefox")>=1 || opera || mozilla) 
		{ 
			if(obj.files && window.URL.createObjectURL) 
			{ 
				return window.URL.createObjectURL(obj.files[0]); 
			} 
			return obj.value; 
		}
		else if(safari){ 
			if(window.webkitURL.createObjectURL && obj.files){ 
				return window.webkitURL.createObjectURL(obj.files[0]); 
			} 
			return obj.value; 
		}
		return obj.value; 
	} 
} 

//js本地图片预览，兼容ie[6-9]、火狐、Chrome17+、Opera11+、Maxthon3
  function PreviewImage(fileObj, imgPreviewId, divPreviewId,conuploadCav) {
	  
	  //multiple="multiple" if (fileObj.type.indexOf('image') == -1) {return;}
	  
      var allowExtention = ".jpg,.bmp,.gif,.png"; //允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
      var extention = fileObj.value.substring(fileObj.value.lastIndexOf(".") + 1).toLowerCase();
      var browserVersion = window.navigator.userAgent.toUpperCase();

       /* 生成图片
      * ---------------------- */
      var $img = new Image();
      $img.onload = function() {

          //生成比例
          var width = $img.width,
                  height = $img.height,scale;
                  
          if(width>height)
          {
              scale = width / height;
	          width = parseInt(800);
	          height = parseInt(width / scale);
          }
          else
          {
              scale = height / width;
	          height = parseInt(800);
	          width = parseInt(height / scale);
          }

          //生成canvas
          var $canvas = $("#" + conuploadCav);
          var ctx = $canvas[0].getContext('2d');
          $canvas.attr({width : width, height : height});
          ctx.drawImage($img, 0, 0, width, height);
      }
      $img.src = getFullPath(fileObj);

  
      /*var canvas = document.getElementById(conuploadCav),
      ctx = canvas.getContext("2d");
      
      
      document.getElementById(imgPreviewId).onload = function() {
			  
			//生成比例
			  var width = document.getElementById(imgPreviewId).width,
			          height = document.getElementById(imgPreviewId).height,
			          scale = width / height;
			  width = parseInt(800);
			  height = parseInt(width / scale);
			
			  //生成canvas
			  var $canvas = $('#canvas');
			  $canvas.attr({width : width, height : height});
			  ctx.drawImage(document.getElementById(imgPreviewId), 0, 0, width, height);
			  
    	  
    	     ctx.drawImage( document.getElementById(imgPreviewId),0,0, canvas.width, canvas.height );
    	    //localStorage.setItem( "savedImageData", canvas.toDataURL("image/png") );
    	  }
      */
      
      if (allowExtention.indexOf(extention) > -1) {
          if (fileObj.files) {//HTML5实现预览，兼容chrome、火狐7+等
              if (window.FileReader) {
                  var reader = new FileReader();
                  reader.onload = function (e) {
                      document.getElementById(imgPreviewId).setAttribute("src", e.target.result);
                  }
                  reader.readAsDataURL(fileObj.files[0]);
              } else if (browserVersion.indexOf("SAFARI") > -1) {
                  alert("不支持Safari6.0以下浏览器的图片预览!");
              }
          } else if (browserVersion.indexOf("MSIE") > -1) {
              if (browserVersion.indexOf("MSIE 6") > -1) {//ie6
                  document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
              } else {//ie[7-9]
                  fileObj.select();
                  if (browserVersion.indexOf("MSIE 9") > -1)
                      fileObj.blur(); //不加上document.selection.createRange().text在ie9会拒绝访问
                  var newPreview = document.getElementById(divPreviewId + "New");
                  if (newPreview == null) {
                      newPreview = document.createElement("div");
                      newPreview.setAttribute("id", divPreviewId + "New");
                      newPreview.style.width = document.getElementById(imgPreviewId).width + "px";
                      newPreview.style.height = document.getElementById(imgPreviewId).height + "px";
                      newPreview.style.border = "solid 1px #d2e2e2";
                  }
                  newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
                  var tempDivPreview = document.getElementById(divPreviewId);
                  tempDivPreview.parentNode.insertBefore(newPreview, tempDivPreview);
                  tempDivPreview.style.display = "none";
              }
          } else if (browserVersion.indexOf("FIREFOX") > -1) {//firefox
              var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
              if (firefoxVersion < 7) {//firefox7以下版本
                  document.getElementById(imgPreviewId).setAttribute("src", fileObj.files[0].getAsDataURL());
              } else {//firefox7.0+                    
                  document.getElementById(imgPreviewId).setAttribute("src", window.URL.createObjectURL(fileObj.files[0]));
              }
          } else {
              document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
          }
      } else {
          alert("仅支持" + allowExtention + "为后缀名的文件!");
          fileObj.value = ""; //清空选中文件
          if (browserVersion.indexOf("MSIE") > -1) {
              fileObj.select();
              document.selection.clear();
          }
          fileObj.outerHTML = fileObj.outerHTML;
      }
      
      return fileObj.value;    //返回路径
  }