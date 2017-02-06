var imgDivs;
var images;
var listItems;
var bikeDescList;
$(document).ready(function(){
        imgDivs = $("div.item"); 
        images = $("div.item").children();
        listItems = $("ol.carousel-indicators").children();
        bikeDescList = $('p.bike-desc');  
        console.log(bikeDescList.innerHTML);
        bikeDescList[0].textContent = "cbr600 is good";
        bikeDescList.css("margin-left", images.css("margin-left"))
    $("#searchBtn").click(searchBar);
    $("#searchBar2").keypress(function(e){
        if(e.keyCode == 13){
           searchBar();
        }
    })

    });

// console.log($('.carousel').carousel({}));
// $(function(){
//     $('.carousel').carousel({
//       interval: 1000
//     });
// });

var searchBar = function(){
        if ($('#searchBar2').val()== 'mt-07' &&  !$('div.item')[2].classList.contains('active'))
        {
            bikeDescList[0].textContent = "mt-07 is good";
            for(var i = 0; i < imgDivs.length; i++)
            {
                console.log(imgDivs[i].classList);
                if (imgDivs[i].classList.contains('active'))
                {   
                    listItems[i].classList.remove('active');
                    imgDivs[i].classList.remove('active');
                }
            }
            imgDivs[2].className += ' active';
            listItems[2].className += ' active';

        
    }
    else if ($('#searchBar2').val() == 'r6' && !$('div.item')[1].classList.contains('active'))
        {
            bikeDescList[0].textContent = "The YZF-R6 is a legend! On the street and with 3 Supersport World titles in recent years also on the race track. One ride on this MotoGP-bred racer and you enter the exciting world of Yamaha. R WORLD! Featuring newly developed low-drag bodywork and an aggressive look that bears all the characteristics of Yamaha's thoroughbred R-series DNA, the new YZF-R6 has arrived. And with its advanced electronics and next level aerodynamics, the YZF-R6 gives you extreme supersport performance with absolute control.";
             for(var i = 0; i < imgDivs.length; i++)
             {
                if (imgDivs[i].classList.contains('active'))
                {   
                    listItems[i].classList.remove('active');
                    imgDivs[i].classList.remove('active');
                }
            }
            imgDivs[1].className += ' active';
            listItems[1].className += ' active';
        }
        else if (($('#searchBar2').val() == 'cbr600' || $('#searchBar2').val() == 'cbr') && !$('div.item')[0].classList.contains('active'))
             {
            bikeDescList[0].textContent = "cbr600 is good";
             for(var i = 0; i < imgDivs.length; i++)
             {
                if (imgDivs[i].classList.contains('active'))
                {   
                    listItems[i].classList.remove('active');
                    imgDivs[i].classList.remove('active');
                }
            }
            imgDivs[0].className += ' active';
            listItems[0].className += ' active';
        }
    }