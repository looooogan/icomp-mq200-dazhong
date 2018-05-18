/**
 * 全局上下文
 */
var context = {
	isLogin : undefined,
	curPage : null,
	userStatus : null,
	orders:null,
	disImgData : null,
	upImgData : null,
	threadObject : null
};

//页面实例
var pages = {};

// 基础结构，统一处理的模式
// 1:用isBack代替模拟onRestart
// 2:login 拦截
// 3:统一的跳转条件拦截 beforeChange
$(document).on("pagebeforechange", function(e, data) {
	// data.to不是string有两种情况，其中一个是代码，另一个是第二次触发（虽然说要取消这种情况）。
	// 因为可能执行两次，所以 这里的方法都应该是幂等的
	// 不是string的话目前没找到改变目标页的方法，所以自己change并且preventDefault
	var to;
	window.localStorage.login = "true"
	if (typeof (data.toPage) === "string") {
		to = data.toPage.replace(/[^#]*#/, "");
	} else {
		to = (data.toPage)[0].id;
	}
	var page = pages[to];
	if (page && page.beforeChange && !page.beforeChange()) {
		e.preventDefault();
		$.mobile.pageContainer.pagecontainer("change", "#login");
	}

});

// 统一处理登陆 定制JQM跳转逻辑
$(document).on('click', ':jqmData(login="1")', function(e) {
	if (!context.isLogin) {
		showMsg("请先登陆");
		setTimeout(function() {
			$.mobile.pageContainer.pagecontainer("change", "#login");
		}, 1);
		e.stopImmediatePropagation();
		e.preventDefault();
	}

});

/**
 * 以下是模拟android的生命周期方法
 */

// 模拟onCreate
$(document).on("pagecreate", function(event) {

	var page = pages[event.target.id];
	if (!page)
		return;
	page.ui = $(event.target);
	if (page.onCreate) {
		page.onCreate();
	}
});

// 模拟onStart
$(document).on("pagebeforeshow", function(event, data) {
	var page = pages[event.target.id];
	if (!page)
		return;
	if (page.onStart) {
		page.onStart(data.prevPage);
	}
});

/**
 * 以下都是common method
 */
function getActivePage() {
	return $.mobile.pageContainer.pagecontainer("getActivePage");
}

// 模拟onResume
$(document).on("pagecontainershow", function(event, ui) {
	// 标题
	var title = $.mobile.activePage.jqmData("title");
	$("#common-header h3").text(title);

	var page = pages[getActivePage()[0].id];
	if (!page)
		return;
	if (page.onResume) {
		page.onResume(ui.prevPage);
		
	}
	context.curPage=page;
});

// onPause 难以模拟 所以忽略
// 模拟onStop
// onstop在onResume之前
$(document).on("pagehide", function(event, data) {
	var page = pages[event.target.id];
	if (!page)
		return;
	if (page.onStop) {
		page.onStop(data.nextPage);
	}
});

/**
 * ajax 通用处理
 */

// 错误处理,显示错误
var ajaxErrorFunction = function(jqXHR, statusText, error) {
	if (statusText != "abort") {
		popInfo(jqXHR.responseText);
	}
};

/**
 * generalpop
 */
function initInfoPop() {
	var pop = $('#info-popup').popup();
	var content = $(".ui-content", pop);
	var onOK;
	
	$('[href="#"]',pop).on('click',function(){

		if (onOK) {
			onOK();
		}
		onOK = null;
		
	});
	
	window.popInfo = function(html,okFun) {
		content.empty().html(html).enhanceWithin();
		pop.popup("open");
		onOK = okFun;
	};
}

/**
 * pic pop
 */
function initPicPop() {
	var pop = $('#pic-popup').enhanceWithin().popup();
	var img = $('img', pop).css('max-height', window.screen.height - 50).css(
			'max-width', window.screen.width - 30);

	window.picPopup = function(src, w, h) {
		img.attr('src', src).attr({
			"height" : h || 300,
			"width" : w || 300
		});
		;
		pop.popup("open", {
			transition : "fade",
			positionTo : "window"
		});
	};

};

/**
 * 确认框
 */
function initConfirmPop() {
	var pop = $('#confirm-popup').enhanceWithin().popup({
		history : false
	});
	var header = $('h1', pop);
	var defHeaderTxt = "提示";
	var info = $('h3', pop);
	var defInfoTxt = "你确定此操作？";
	var commet = $('p', pop);
	var defCommetTxt = "";

	var onOK = null;

	$(':jqmData(type="0")', pop).on('click', function() {
		onOK = null;
		pop.popup("close");
	});

	$(':jqmData(type="1")', pop).on('click', function() {
		pop.popup("close");
		if (onOK) {
			onOK();
		}
		onOK = null;
	});

	window.popupConfirm = function(okfn, options) {
		onOK = okfn;
		if (options) {
			header.text(options.header || defHeaderTxt);
			info.text(options.info || defInfoTxt);
			commet.text(options.commet || defCommetTxt);
		}
		pop.popup("open");
	};

};

function loginInit()
{
	$("#loginOut").on('click',function() {
		
		
	});
}

function loginOut()
{
	window.localStorage.login = "false";
	$("#menu").hide();
	$("#menus").hide();
	var me = this;
	me.mjqXHR = $.ajax({
		type : "POST",
		dataType : "json",
		url : x.basePath + "/doLoginOut"
	}).done(function(d, e, jqXHR) {
	}).fail(function(jqXHR, statusText, error) {
	}).complete(function(jqXHR) {
		$.mobile.pageContainer.pagecontainer("change", "#login");
		clearInterval(context.threadObject);
		context.threadObject = null;
		if(pages.temperatureMonitoring)
			{
			pages.temperatureMonitoring.dateTihuo = '';
			}
		
		//关闭   结束
	});
}

/**
 * 以下是初始流程
 */
$(function() {
	initConfirmPop();
	initInfoPop();
	initPicPop();
	//loginInit();
});


CanvasRenderingContext2D.prototype.clear = 
  CanvasRenderingContext2D.prototype.clear || function (preserveTransform) {
    if (preserveTransform) {
      this.save();
      this.setTransform(1, 0, 0, 1, 0, 0);
    }
 
    this.clearRect(0, 0, this.canvas.width, this.canvas.height);
 
    if (preserveTransform) {
      this.restore();
    }           
};

var opt={};
$(function () {
	var currYear = (new Date()).getFullYear();	
	opt.date = {preset : 'date'};
	//opt.datetime = { preset : 'datetime', minDate: new Date(2012,3,10,9,22), maxDate: new Date(2014,7,30,15,44), stepMinute: 5  };
	opt.datetime = {preset : 'datetime'};
	opt.time = {preset : 'time'};
	opt.defaultVal = {
			//theme: 'android-ics light', //皮肤样式
		theme: 'sense-ui', //皮肤样式
		display: 'modal', //显示方式 
	    dateFormat: 'yyyy-mm-dd', // 日期格式
		mode: 'scroller', //日期选择模式
		lang:'zh',
		startYear:currYear - 200, //开始年份
		endYear:currYear + 100, //结束年份
	      setText: '确定', //确认按钮名称
	      cancelText: '取消',//取消按钮名籍我
	      dateOrder: 'yymmdd', //面板中日期排列格式
	      dayText: '日', monthText: '月', yearText: '年', //面板中年月日文字
	      hourText: "时",
		  minuteText: "分",
		  ampmText:"上午/下午"
	};
});

function GetRandomNum(Min,Max)
{   
	var Range = Max - Min;   
	var Rand = Math.random();   
	return(Min + Math.round(Rand * Range));   
}

function isNull(val)
{
	return (val =="''" || val=='null')?null:val;	
}
