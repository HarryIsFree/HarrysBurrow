var angle_h = 0;
var angle_m = 0;
var flow_st = 0;
var mouse_x;
var mouse_y;
var drag = false;
var init_margin  = 414;
var slide_margin = 414; 
var weekdays = ["星期一","星期二","星期三","星期五","星期六","星期天"];


// State whether the phone is locked.
var locked = false;

$(document).ready(function(){
	setTime();
	window.setInterval(setTime,1000);
	window.setInterval(flow_anim,200);
	events();
	
	lock();
});

function setTime(){
	var d = new Date();
	var t = (d.getHours()<10?("0"+d.getHours()):d.getHours())+":"+(d.getMinutes()<10?("0"+d.getMinutes()):d.getMinutes());
	$('.time').html(t);
	$('.time_dc').html(t);
	
	var date = (d.getMonth()+1)+"月"+d.getDate()+"日"+"&nbsp"+weekdays[d.getDay()];
	$('.time_date').html(date);
	
	angle_h = d.getHours()%12 * 30 + 0.5*(d.getMinutes()%60) + "deg";
	angle_m = d.getMinutes()%60*6 + "deg";
	
	document.getElementById("stick1").style.webkitTransform = "rotate("+angle_h+")";
	document.getElementById("stick2").style.webkitTransform = "rotate("+angle_m+")";
}

function flow_anim(){
	var color1 = "rgba(255,255,255,0.2)";
	var color2 = "rgba(255,255,255,0.5)";
	var color3 = "rgba(255,255,255,1)";
	switch(flow_st){
	case 0:{
		$('.unlock_block1').css('background',color1);
		$('.unlock_block2').css('background',color1);
		$('.unlock_block3').css('background',color1);
		$('.unlock_arrow1').css('background',color1);
		$('.unlock_arrow2').css('background',color1);
		break;
	}
	case 1:{
		$('.unlock_block1').css('background',color2);
		$('.unlock_block2').css('background',color1);
		$('.unlock_block3').css('background',color1);
		$('.unlock_arrow1').css('background',color1);
		$('.unlock_arrow2').css('background',color1);
		break;
	}
	case 2:{
		$('.unlock_block1').css('background',color3);
		$('.unlock_block2').css('background',color2);
		$('.unlock_block3').css('background',color1);
		$('.unlock_arrow1').css('background',color1);
		$('.unlock_arrow2').css('background',color1);
		break;
	}
	case 3:{
		$('.unlock_block1').css('background',color2);
		$('.unlock_block2').css('background',color3);
		$('.unlock_block3').css('background',color2);
		$('.unlock_arrow1').css('background',color1);
		$('.unlock_arrow2').css('background',color1);
		break;
	}
	case 4:{
		$('.unlock_block1').css('background',color1);
		$('.unlock_block2').css('background',color2);
		$('.unlock_block3').css('background',color3);
		$('.unlock_arrow1').css('background',color2);
		$('.unlock_arrow2').css('background',color2);
		break;
	}
	case 5:{
		$('.unlock_block1').css('background',color1);
		$('.unlock_block2').css('background',color1);
		$('.unlock_block3').css('background',color2);
		$('.unlock_arrow1').css('background',color3);
		$('.unlock_arrow2').css('background',color3);
		break;
	}
	case 6:{
		$('.unlock_block1').css('background',color1);
		$('.unlock_block2').css('background',color1);
		$('.unlock_block3').css('background',color1);
		$('.unlock_arrow1').css('background',color2);
		$('.unlock_arrow2').css('background',color2);
		break;
	}
	case 7:{
		$('.unlock_block1').css('background',color1);
		$('.unlock_block2').css('background',color1);
		$('.unlock_block3').css('background',color1);
		$('.unlock_arrow1').css('background',color1);
		$('.unlock_arrow2').css('background',color1);
		break;
	}
	}
	flow_st = (flow_st+1)%8;
}

// Initialize events
function events(){
	$('.unlock_button').mouseover(function(){
		$('.slide_bg').css('background','-webkit-gradient(radial,50% 20%,0,50% 0%,300,from(rgba(255,153,0,0.9)),to(rgba(255,153,0,0.1)))');
		$('.highlight').css('background','-webkit-gradient(radial, 50% 50%,23,50% 50%,33,from(rgba(255,153,0,0.1)),to(rgba(255,153,0,1)))');
	});
	$('.unlock_button').mouseout(function(){
		$('.slide_bg').css('background','rgba(255,255,255,0.1)');
		$('.highlight').css('background','transparent');
	});
	$('.unlock_button').mousedown(function(evt){
		var position = $('.slide_unlock').position();
		mouse_y = evt.pageY;
		drag = true;
	});
	$('.unlock_button').mousemove(function(evt){
		if(drag){
			var delta = evt.pageY - mouse_y;
			init_margin += delta;
			if(init_margin<slide_margin){
				init_margin = slide_margin;
			}
			else if(init_margin>slide_margin+240){
				unlock();
			}
			$('.slide_unlock').css('margin-top',init_margin+"px");
			mouse_y = evt.pageY;
		}
	});
	$('.unlock_button').mouseup(function(){
		drag = false;
		if(init_margin<slide_margin+120){
			init_margin = slide_margin;
			$('.slide_unlock').css('margin-top',init_margin+"px");
		}
		else{
			unlock();
		}
	});
	$('.slide_unlock').mouseup(function(){
		drag = false;
	});
}

// Lock the phone
function lock(){
	$('.status_bar').css('background','transparent');
	$('.clock_div').animate({opacity:"0"},1000);
	$('.bottom').animate({opacity:"0"},1000);
	$('.time_zone').animate({opacity:"1"},1000);
	$('.slide_unlock').animate({opacity:"1"},1000);
}

// Unlock the phone
function unlock(){
	$('.status_bar').css('background','rgba(54,54,54,0.7)');
	$('.clock_div').animate({opacity:"1"},1000);
	$('.bottom').animate({opacity:"1"},1000);
	$('.slide_unlock').css('opacity',0);
	$('.slide_unlock').css('margin-top','414px');
	$('.time_zone').animate({opacity:"0"},1000);
}