<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Box Office</title>
</head>

<body onload="">
	<div class="container">
		<div class="jumbotron" style="margin: 45px 0px">
			<h2 class="text-center">Box Office APP</h2>
		</div>
       <!-- On Submit the form it will make request to the server
        http://localhos:8080/application/savenews
        form is associated with model-->

		<form method="POST" action="saveMovie" modelAttribute="movie">

			<div class="form-group">
				<label for="movieId">Movie ID</label>
				<input type="text"
					class="form-control" id="movieId" aria-describedby="name"
					placeholder="Enter Movie ID" name="movieId">
			</div>

			<div class="form-group">
				<label for="movieName">Movie Title</label>
				<input type="text"
					class="form-control" id="movieName" aria-describedby="name"
					placeholder="Enter Movie Title" name="movieName">
			</div>

			<div class="form-group">
				<label for="movieDirector">Movie Director</label>
				<input type="text"
				    class="form-control" id="movieDirector"
					placeholder="Enter Movie Director" name="movieDirector">
			</div>

			<div class="form-group">
				<label for="movieHero">Movie Hero</label>
				<input type="text" class="form-control" id="movieHero"
					placeholder="Enter Movie Hero" name="movieHero">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


		<div style="margin-top: 1em; text-align: center">
			<h2>All Movies Information</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Movie ID</th>
						<th scope="col">Movie Title</th>
						<th scope="col">Movie Director</th>
						<th scope="col">Movie Hero</th>
					</tr>
				</thead>
				<tbody id='table-body'>
					<c:forEach items="${movieList}" var="movieobj">
						<tr>
							<td>${movieobj.movieId}</td>
							<td>${movieobj.movieName}</td>
							<td>${movieobj.movieDirector}</td>
							<td>${movieobj.movieHero}</td>
							<td>Update</td>
							<td>Delete</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>