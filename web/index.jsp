
<html>
  <head>
    <title>Expedia Hotels</title>
      <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

    <script>
        <%@include file="/js/home.js" %>
    </script>
    <style>
      <%@include file="/css/style.css" %>
    </style>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


      <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  </head>
  <body>


  <div>
    <div class="SearchForm" style="padding:30px; border:10px solid darkgray;" >
        <label for="destinationName">Destination City: </label></br>
        <input type="text" name="destinationName" id="destinationName"/>
        </br>
        <label for="minTripStartDate">Min Trip Start Date: </label>
        <input type="date" class="form-control" id="minTripStartDate" style="width: 200px">
        </br>
        <label for="maxTripStartDate">Max Trip Start Date: </label>
        <input type="date" class="form-control" id="maxTripStartDate" style="width: 200px">
        </br>
        <label for="lengthOfStay">Length of Stay: </label>
        <input type="number" id="lengthOfStay"/>


        </br></br>

        <labal for="minStarRating" style="font-weight: 700" > Minimum Start Rating: </labal>
        <input type="number" min="1" max="5" value="1" id="minStarRating">

        </br></br>


        <labal for="maxStarRating" style="font-weight: 700"> Maximum Start Rating:</labal>
        <input type="number" min="1" max="5" value="1" id="maxStarRating">


        </br></br>
      <button id="SearchBtn" class="btn btn-primary my-btn">
        Search!
      </button>
    </div>

  </div>

  <div id="searchResult">

  </div>

  </body>
</html>
