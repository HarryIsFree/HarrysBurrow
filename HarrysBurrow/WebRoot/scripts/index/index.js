$(document).ready(function(){

	testBrowserVersion();
	bindEvents();
	
});

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
			
		}
		else if(id=='who'){
			
		}
		
		$('#dialog').dialog();
		
	});
}