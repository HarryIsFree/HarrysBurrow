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
	mHeight += 20;
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
		else if(id=='miui'){
			window.location = 'MIUI/miui.html';
		}
		
	});
	
	$('#close').mouseenter(function(){
		$('#close').attr('src','img/index/close_over.jpg');
	});
	$('#close').mousedown(function(){
		$('#close').attr('src','img/index/close_pressed.jpg');
	});
	$('#close').mouseout(function(){
		$('#close').attr('src','img/index/close.jpg');
	});
	$('#close').click(function(){
		dismissDialog();
	});
}

function getContent(ID){
	// decode url
	var deurl = BASE64.decode(enurl);
	$('#mask').fadeIn('fast');
	$('#loading').fadeIn('slow');
	
	// Use jQuery ajax to get required content
	$.ajax({
		url: deurl,
		type: "POST",
		data: {id : ID},
		dataType: "html"
	}).done(function(msg){
		$('#loading').fadeOut('slow',function(){
			$('#dialog_content').html(msg);
			var height = $('#dialog').height()+100;
			$('#mask').css('height',height);
			$('#dialog').fadeIn('slow');
			$('#mask').click(function(){
				dismissDialog();
			});
		});
	});
}

function dismissDialog(){
	$('#dialog').fadeOut('slow',function(){
		$('#mask').fadeOut('fast');
	});
	adjustElements();
}