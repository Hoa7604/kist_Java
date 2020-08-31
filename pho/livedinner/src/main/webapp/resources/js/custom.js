window.onload = function(){
    document.captureEvents(MouseEvent);
    document.onmousedown = mouseEvent;

    //active class
    activeChanges = document.querySelectorAll('li a');
    for (let i = 0; i < activeChanges.length; i++) {

        activeChanges[i].addEventListener('click', function(){
            var acCurrent = document.getElementsByClassName('active');
            acCurrent[0].className = acCurrent[0].className.replace('active', '');
            // console.log(this.className);
            this.className += 'active';
            
        });
    }

    slider();
   
}

function mouseEvent(e){
    if( e.which == 1){
        showIdx = document.querySelectorAll('.drop-menu');
        for(var i = 0; i < showIdx.length; i++){
            showIdx[i].style.display = 'none';
        }
    }
}


// activeChange();
activeSideChange = document.querySelectorAll('#v-pills-tab a');
// console.log(activeSideChange);
    for (let i = 0; i < activeSideChange.length; i++) {
        activeSideChange[i].addEventListener('click', function(){
            var acCurrent = document.getElementsByClassName('active');
            acCurrent[0].className = acCurrent[0].className.replace('active', '');
            this.className += 'active';
        });
}

//menu show
function show(divId){
    showIdx = document.querySelectorAll('.drop-menu');  
    heightLi = document.querySelector('#navbars-rs-food ul li');

    for(var i = 0; i < showIdx.length; i++)
    {
        if (showIdx[i].id == divId) {
            showIdx[i].style.display = 'block';
        }else{
            showIdx[i].style.display = 'none';
        }
    }
    subId = document.getElementById(divId);
    if (subId.style.display == 'block'  ) {
        subId.style.display = 'none';
    }else{
        subId.style.display = 'block';
    }
}

// -------
// btnClick = document.querySelectorAll('#dropdown-a');
// showSubMenu = document.querySelectorAll('.drop-menu');
// indx1 = document.getElementById('subPage');
// indx2 = document.getElementById('subBlog');
// for (let j = 0; j < showSubMenu.length; j++) {
//     if (showSubMenu[j].id != indx1 &&  showSubMenu[j].id != indx2) {
//         showSubMenu[j].style.display = 'none';
//     }
// }   
// for (let i = 0; i < btnClick.length; i++) {  
//     btnClick[i].addEventListener('click', function(){
//         if (indx1.style.display == 'block') {
//             indx1.style.display == 'none';
//         }else{
//             indx1.style.display == 'block';
//         }

//         if (indx2.style.display == 'block') {
//             indx2.style.display == 'none';
//         }else{
//             indx2.style.display == 'block';
//         }
//     });
// } 

//autoSlider
var slideAuto = 0;
autoSlide();

function autoSlide(){
    mySlide = document.querySelectorAll('.slide-wrap li');
   
    for (let i = 0; i < mySlide.length; i++) {
        mySlide[i].style.display = 'none';
    }

    slideAuto++;
    if ( slideAuto > mySlide.length) {
        slideAuto = 1;
    }
    dotChange = document.querySelectorAll('.slide-paging li');
    for (let i = 0; i < dotChange.length; i++) {
        dotChange[i].className = dotChange[i].className.replace('changeColor','');          
    }

    mySlide[slideAuto-1].style.display = 'block';
    dotChange[slideAuto - 1].className += ' changeColor';
    setTimeout(autoSlide, 4000);
}

//slider
var index = 1;
addFunc(index);

function activeChange(n){
    addFunc(index += n);
}

function changeDot(n){
    addFunc(index = n);
}

function addFunc(n){
   
    mySlide = document.querySelectorAll('.slide-wrap li');
    dotChange = document.querySelectorAll('.slide-paging li');
    if(n > mySlide.length){index = 1}
    if(n < 1){index = mySlide.length}
    for (let i = 0; i < mySlide.length; i++) {
        mySlide[i].style.display = 'none';
    }

    for (let i = 0; i < dotChange.length; i++) {
        dotChange[i].className = dotChange[i].className.replace('changeColor','');          
    }

    mySlide[index-1].style.display = 'block';
    dotChange[index - 1].className += ' changeColor';
    
}


//side menu left

function sideMenu(divId){
    console.log(divId);
    showIdx = document.querySelectorAll('.wrap-pills');
    console.log(showIdx[0].id);
    for(var i = 0; i < showIdx.length; ++i)
    {
        if (showIdx[i].id != divId) {
            showIdx[i].style.display = 'none';
        }
    }

    subDiv = document.getElementById(divId);
    if(subDiv.style.display == 'block'){
        subDiv.style.display = 'none';
    }else{
        subDiv.style.display = 'block';
        
    }
    
}

//slider bottom customer reviews
// var slideAutocus = 0;
// autoSlideCus();

// function autoSlideCus(){
//     mySlide = document.querySelectorAll('.sub-wrap-cus');
   
//     for (let i = 0; i < mySlide.length; i++) {
//         mySlide[i].style.display = 'none';
//     }

//     slideAutocus++;
//     if ( slideAutocus > mySlide.length-1) {
//         slideAutocus = 1;
//     }

//     mySlide[slideAutocus-1].style.display = 'block';
//     setTimeout(autoSlideCus, 2000);
// }

function moveElement(elementID,final_x, final_y, interval){
    var elem = document.querySelector(elementID);
    if(elem.movement) clearTimeout(elem.movement);
   
    // Xác định vị trí
    var xpos = parseInt(elem.style.left);
    var ypos = parseInt(elem.style.top);
  
    // Sau khi dịch chuyển tới vị trí thì dừng
    if(xpos == final_x && ypos == final_y) return true;
  
    // Tính vị trí dịch chuyển sau mỗi thời gian dừng
    if(xpos < final_x){
     var dist = Math.ceil((final_x - xpos)/10);
     xpos = xpos + dist;
    }
    if(xpos > final_x){
     var dist = Math.ceil((xpos - final_x)/10);
     xpos = xpos - dist;
    }
    if(ypos < final_y){
     var dist = Math.ceil((final_y - ypos)/10);
     ypos = ypos + dist;
    }
    if(ypos > final_y){
     var dist = Math.ceil((ypos - fina_y)/10);
     ypos = ypos - dist;
    }
  
    // Di chuyển phần tử
    elem.style.left = xpos + "px";
    elem.style.top = ypos + "px";
  
    // Gọi lại hàm dịch chuyển sau khi dịch được 1 px
    var repeat = "moveElement('" + elementID + "'," + final_x + ", " + final_y + ", " + interval + ")";
    elem.movement = setTimeout(repeat,interval);
  }

  function previous(){
    if(move <0) move += box_width;
    moveElement('slider',move, 0, 10);
  }
  function next(){
   move = (move <= endpos)? 0: (move-box_width);
   moveElement('slider',move, 0, 10);
  }

  function slider(){
    if(!document.getElementById) return false;
    var slider = document.querySelector('.sub-wrap-cus');
    var wrap_slider = document.querySelector('.slider-wrap-cus');
   
    // Định kiểu cho slider nếu chưa được thiết lập
    if(!slider.style.position) slider.style.position ="absolute";
    if(!slider.style.left) slider.style.left ="0px";
    if(!slider.style.top) slider.style.top = "0px";
  
    // Thiết lập các thông số cho slider
    var box_arr =slider.childNodes;
    var box_quantity =0;
    for(var i=0; i<box_arr.length; i++){
      if(box_arr[i].className == 'sub-wrap-cus'){
       box_quantity++;
       box_width =box_arr[i].offsetWidth;
       box_height =box_arr[i].offsetHeight;
      }
    }
  
    wrap_slider.style.height =box_height+"px";
    wrap_slider.style.width =box_width+"px";
    slider.style.width = (box_width*box_quantity)+"px";
    move=0; endpos = -(box_width*3);
  
    // Tự động chạy slider
    var idSet =setInterval('next()',5000);
   
    // next_slide , prev_slide
    var next_slide = document.querySelector(".next");
    var prev_slide = document.querySelector(".prev");
  
    next_slide.onclick = function(){
      next(); clearInterval(idSet);
      idSet =setInterval('next()',5000);
    }
    prev_slide.onclick = function(){
      previous(); clearInterval(idSet);
      idSet =setInterval('next()',5000);
    }
  }