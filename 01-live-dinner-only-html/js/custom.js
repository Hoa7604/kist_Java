window.onload = function(){
    
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


