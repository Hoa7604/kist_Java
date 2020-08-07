window.onload = function(){
    document.captureEvents(MouseEvent);
    document.onmousedown = mouseEvent;



}

function mouseEvent(e){
    if( e.which == 1){
        showIdx = document.querySelectorAll('.drop-menu');
        for(var i = 0; i < showIdx.length; i++){
            showIdx[i].style.display = 'none';
        }
    }
    
}

//active class
activeChanges = document.querySelectorAll('li a');
    for (let i = 0; i < activeChanges.length; i++) {
        activeChanges[i].addEventListener('click', function(){
            var acCurrent = document.getElementsByClassName('active');
            acCurrent[0].className = acCurrent[0].className.replace('active', '');
            this.className += 'active';
        });
}
// activeChange();
activeSideChange = document.querySelectorAll('#v-pills-tab a');
console.log(activeSideChange);
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
    for(var i = 0; i < showIdx.length; i++)
    {
        if (showIdx[i].id != divId) {
            showIdx[i].style.display = 'none';
        }
    }

    subId = document.getElementById(divId);
    if (subId.style.display == 'block') {
        subId.style.display = 'none';
    }else{
        subId.style.display = 'block';
    }
}

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
var slideAutocus = 0;
autoSlideCus();

function autoSlideCus(){
    mySlide = document.querySelectorAll('.sub-wrap-cus');
   
    for (let i = 0; i < mySlide.length; i++) {
        mySlide[i].style.display = 'none';
    }

    slideAutocus++;
    if ( slideAutocus > mySlide.length-1) {
        slideAutocus = 1;
    }

    mySlide[slideAutocus-1].style.display = 'block';
    setTimeout(autoSlideCus, 2000);
}

