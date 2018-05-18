/**
 * 命名控件
 */
var x = {};
//用于存放全局数据
x.data={};
//用来存放函数
x.fn={};


(function() {

	// rootpath
	x.basePath = (function() {
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		return localObj.protocol + "//" + localObj.host + "/" + contextPath;
	})();

	// 将form表单元素的值序列化成对象 以来jquery
	x.serializeObject = function(form) {
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	};

	// 格式化字符串
	x.formatString = function(str) {
		for ( var i = 0; i < arguments.length - 1; i++) {
			str = str.replace("{" + i + "}", arguments[i + 1]);
		}
		return str;
	};

	// 转义HTML
	x.strToHTML = function(val) {
		if(!val){
			return;
		}
		return $("<span></span>").text(val).html();
	};

	// 浏览器版本
	x.isLessThanIe8 = function() {
		// return ($.browser.msie && $.browser.version < 8);
	};

	// 命名空间功能,可以传多个
	x.ns = function() {
		var o = {}, d;
		for ( var i = 0; i < arguments.length; i++) {
			d = arguments[i].split(".");

			o = window;
			for ( var k = 0; k < d.length; k++) {
				o = o[d[k]] = o[d[k]] || {};
			}
		}
	};

	// 判断空元素
	x.isEmpty = function(obj, own) {
		for ( var name in obj) {
			if (own ? obj.hasOwnProperty(name) : true) {
				return false;
			}
		}
		return true;
	};
	
	//只要不返回TRUE就中序遍历 知道为true
	x.prcessTree = function(node, f) {
		var r=f(node);
		if(r)
			return r;
		if (!(node.children && node.children.length > 0))
			return null;
		for ( var i = 0; i < node.children.length; i++) {
			r=arguments.callee(node.children[i],f);
			if (r)
				return r;
		}
		return null;
	};
	
	x.q=function(pname){
		var query = location.search.substring(1);
		var qq = "";
		params = query.split("&");
		if(params.length>0){
			for(var n in params){
				var pairs = params[n].split("=");
				if(pairs[0]==pname){
					qq = pairs[1];
					break;
				}
			}
		}
		return qq;
	};
	
	/*	x.data._loadedScripts={};
		x.getScript=function(url,callback){
		if(!x.data._loadedScripts[url]){
			jQuery.ajaxPrefilter( "script", function( s ) {
				if ( s.cache === undefined ) {
					s.cache = false;
				}
				// 强制设置为缓存
				s.cache = true;
				if ( s.crossDomain ) {
					s.type = "GET";
					s.global = false;
				}
			});
			$.getScript(url, function(){
				x.data._loadedScripts[url]=1;
				callback();
			});
			
		}else{
			callback();
		}
	};*/


})();

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

/*
 * MAP对象，实现MAP功能
 *
 * 接口：
 * size()     获取MAP元素个数
 * isEmpty()    判断MAP是否为空
 * clear()     删除MAP所有元素
 * put(key, value)   向MAP中增加元素（key, value) 
 * remove(key)    删除指定KEY的元素，成功返回True，失败返回False
 * get(key)    获取指定KEY的元素值VALUE，失败返回NULL
 * element(index)   获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
 * containsKey(key)  判断MAP中是否含有指定KEY的元素
 * containsValue(value) 判断MAP中是否含有指定VALUE的元素
 * values()    获取MAP中所有VALUE的数组（ARRAY）
 * keys()     获取MAP中所有KEY的数组（ARRAY）
 *
 * 例子：
 * var map = new Map();
 *
 * map.put("key", "value");
 * var val = map.get("key")
 * ……
 *
 */
function Map() {
    this.elements = new Array();
 
    //获取MAP元素个数
    this.size = function() {
        return this.elements.length;
    }
 
    //判断MAP是否为空
    this.isEmpty = function() {
        return (this.elements.length < 1);
    }
 
    //删除MAP所有元素
    this.clear = function() {
        this.elements = new Array();
    }
 
    //向MAP中增加元素（key, value) 
    this.put = function(_key, _value) {
        this.elements.push( {
            key : _key,
            value : _value
        });
    }
 
    //删除指定KEY的元素，成功返回True，失败返回False
    this.remove = function(_key) {
        var bln = false;
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].key == _key) {
                    this.elements.splice(i, 1);
                    return true;
                }
            }
        } catch (e) {
            bln = false;
        }
        return bln;
    }
 
    //获取指定KEY的元素值VALUE，失败返回NULL
    this.get = function(_key) {
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].key == _key) {
                    return this.elements[i].value;
                }
            }
        } catch (e) {
            return null;
        }
    }
    //更新所有Value值
    this.updateValues = function(oldVal,newVal)
    {
    	try
    	{
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].value == oldVal) {
                    this.elements[i].value = newVal;
                }
            }
    	}
    	catch(e)
    	{}
    }
        
 
    //获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
    this.element = function(_index) {
        if (_index < 0 || _index >= this.elements.length) {
            return null;
        }
        return this.elements[_index];
    }
 
    //判断MAP中是否含有指定KEY的元素
    this.containsKey = function(_key) {
        var bln = false;
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].key == _key) {
                    bln = true;
                }
            }
        } catch (e) {
            bln = false;
        }
        return bln;
    }
 
    //判断MAP中是否含有指定VALUE的元素
    this.containsValue = function(_value) {
        var bln = false;
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].value == _value) {
                    bln = true;
                }
            }
        } catch (e) {
            bln = false;
        }
        return bln;
    }
 
    //获取MAP中所有VALUE的数组（ARRAY）
    this.values = function() {
        var arr = new Array();
        for (i = 0; i < this.elements.length; i++) {
            arr.push(this.elements[i].value);
        }
        return arr;
    }
 
    //获取MAP中所有KEY的数组（ARRAY）
    this.keys = function() {
        var arr = new Array();
        for (i = 0; i < this.elements.length; i++) {
            arr.push(this.elements[i].key);
        }
        return arr;
    }
    
    this.set = function(key,value)
    {
        for (i = 0; i < this.elements.length; i++) {
        	if(this.elements[i].key == key)
    		{
        		this.elements[i].value = value;
    		}
        }
    }    
}