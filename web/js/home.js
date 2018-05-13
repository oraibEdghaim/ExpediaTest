
$(document).ready(function() {


$("#SearchBtn").click(function () {
    var minTripStartDate = document.getElementById('minTripStartDate').value;
    var maxTripStartDate = document.getElementById('maxTripStartDate').value;
    var lengthOfStay = document.getElementById('lengthOfStay').value;
    var destinationName = document.getElementById('destinationName').value;
    var minStarRating = document.getElementById('minStarRating').value;
    var maxStarRating = document.getElementById('maxStarRating').value;

        $.ajax({
            url: "Master",
            type: "POST", //send it through get method
            data: {
                destinationName: destinationName,
                minTripStartDate: minTripStartDate,
                maxTripStartDate: maxTripStartDate,
                lengthOfStay : lengthOfStay,
                minStarRating : minStarRating,
                maxStarRating : maxStarRating

            },
            success: function(response) {
                updateSearchResult(JSON.parse(response));
            },
            error: function(xhr) {
                //Do Something to handle error
            }
        });



    });

    function updateSearchResult(json) {
        var html = "";
        $.each(json,function () {

            var cur = JSON.parse(this);
            var str = '  <div class="container-fluid" style="border:2px solid deepskyblue ; width: 50%;">\n' +
                '      <br class="col" style="width: 1000px">\n' +
                '          <div class="col-xs-1">\n' +
                '              <img src="$IMG_URL" style=" border-radius:2px;"/>\n' +
                '          </div>\n' +
                '          <div class="col-lg-6">\n' +
                '              <a style ="  font-style: italic;\n' +
                '    font-size: 20;\n' +
                '    font-weight: 250; margin-left:20px;">$HOTEL NAME</a>\n' +
                '          </div>\n' +
                '          </br><div class="col-xs-2">\n' +
                '              <lable style ="    font-style: italic;\n' +
                '    font-size: 20;">Price : </lable><a style="font-size: 20;">$PRICE</a>\n' +
                '          </div>\n' +
                '          </div>\n' +

                '      </div></div>';

            str = str.replace("$HOTEL NAME",cur.hotelInfo.hotelName)
                .replace("$IMG_URL",cur.hotelInfo.hotelImageUrl)
                .replace("$PRICE",cur.hotelPricingInfo.averagePriceValue);
            html+=str;
        });

        $("#searchResult").html(html);



    }
});
