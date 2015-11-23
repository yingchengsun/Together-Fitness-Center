(function($){

$.bstablecrosshair = function(id,options){

tdn = $('#'+id+' td').length;
trn = $('#'+id+' tr').length;

tdc = tdn / trn;

for(cnr = 0;cnr <= trn-1;cnr++) {

 for(cnc = 0;cnc <= tdc-1;cnc++) {

 mp = cnr*tdc + cnc;
  $('#'+id+' td').eq(mp).addClass('c'+cnc+'n');
 
 
 }

}


defaultc = "red";
defaultbg = "black";
defaultfg = "white";
cols = 5;


if(options) {
if(!options.color) {
color = defaultc;
}else {
color = options.color;
}

if(!options.background) {
background = defaultbg;
}else {
background = options.background;
}

if(!options.foreground) {
foreground = defaultfg;
}else {
foreground = options.foreground;
}


}else {
color = defaultc;
background = defaultbg;
}

chtd = $('#'+id+' td');
chtd.each(function(){

$(this).mouseover(function(){

cv = $(this).attr('class');
$('.'+cv).each(function(){
$(this).css({
'background-color' : background,
'color' : foreground
});
});

$(this).css({
'background-color' : color,
'color' : foreground
});


});


$(this).mouseout(function(){
$(this).css({
'background-color' : '',
'color' : ''
});

cv = $(this).attr('class');
$('.'+cv).each(function(){
$(this).css({
'background-color' : '',
'color' : ''
});
});


});


});

chtr = $('#'+id+' tr');
chtr.each(function(){

$(this).mouseover(function(){
$(this).css({
'background-color' : background,
'color' : foreground
});
});


$(this).mouseout(function(){
$(this).css({
'background-color' : '',
'color' : ''
});
});


});


};

})(jQuery);