var enurl = "c2VydmxldC9Db250ZW50U2VydmxldA==";

$(document).ready(function(){

	adjustElements();
	testBrowserVersion();
	bindEvents();
	//getContent(1);
});

function adjustElements(){
	
	// adjust the height of mask
	var bHeight = $('body').height();
	var wHeight = $(window).height();
	var mHeight = bHeight>wHeight?bHeight:wHeight;
	$('#mask').css('height',mHeight);
	
}

function testBrowserVersion(){
	var version = jQuery.browser.version;
	if(jQuery.browser.safari){
		//alert("webkit:" + version);
	}
	else if(jQuery.browser.msie){
		$('#alert_bar').css('display','block');
	}
	else if(jQuery.browser.mozilla){
		//alert("moz:" + version);
	}
	else if(jQuery.browser.opera){
		//alert("op:" + version);
	}
}

function bindEvents(){
	$('.window').click(function(){
		
		var id = $(this).attr('id');
		if(id=='what'){
			getContent(1);
		}
		else if(id=='who'){
			getContent(2);
		}
		
	});
}

function getContent(ID){
	$('#mask').css('display','block');
	$('#dialog').css('display','block');
	//$('#temp').html(BASE64.encode('servlet/ContentServlet'));
	var deurl = BASE64.decode(enurl);
	
	// Use jQuery ajax to get required content
	$.ajax({
		url: deurl,
		type: "POST",
		data: {id : ID},
		dataType: "html"
	}).done(function(msg){
		$('#dialog').html(msg);
	});
}