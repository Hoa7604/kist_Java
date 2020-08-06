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

// var slideAuto = 0;
// autoSlide();

// function autoSlide(){
//     mySlide = document.querySelectorAll('.slide-wrap li');
//     dotChange = document.querySelectorAll('.slide-paging li');
//     for (let i = 0; i < mySlide.length; i++) {
//         mySlide[i].style.display = 'none';
//     }

//     slideAuto++;
//     if ( slideAuto > mySlide.length) {
//         slideAuto - 1;
//     }
//     for (let i = 0; i < dotChange.length; i++) {
//         dotChange[i].className = dotChange[i].className.replace('changeColor','');          
//     }

//     mySlide[index-1].style.display = 'block';
//     dotChange[index - 1].className += ' changeColor';
//     setTimeout(autoSlide, 1000);
// }

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
        mySlide[i].style.opacity = '0';
    }

    for (let i = 0; i < dotChange.length; i++) {
        dotChange[i].className = dotChange[i].className.replace('changeColor','');          
    }

    mySlide[index-1].style.display = 'block';
    if (mySlide[index-1].style.display = 'block') {
        mySlide[index-1].style.opacity = '1';
    }
    dotChange[index - 1].className += ' changeColor';
    
}

