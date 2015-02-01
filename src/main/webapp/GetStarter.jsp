<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="resources/images/faviconSudoku.ico">

<title>Sudoku of the Day</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/starter-template.css" rel="stylesheet">

</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/jSudokuWeb/">Create New Board</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="https://github.com/muzir/jSudokuWeb">Home</a></li>
					<li><a
						href="https://github.com/muzir/jSudokuWeb/blob/master/README.md">About</a></li>
					<li><a href="https://github.com/muzir">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">

		<div class="starter-template">
			<h1>Sudoku Solver written in JAVA</h1>
			<p class="lead">
				Use this document as a way to quickly start any new project about
				sudoku algorithm<br> All you get is this text for now pure
				Java,Spring and Bootstrap UI project.
			</p>

			<div id="sudokuGrid" class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>#</th>
							<th>1</th>
							<th>2</th>
							<th>3</th>
							<th>4</th>
							<th>5</th>
							<th>6</th>
							<th>7</th>
							<th>8</th>
							<th>9</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			<!-- /.table-responsive -->
		</div>
	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
		var i = 0;
		var newRowNumber = 1;
		var newRowContent = "<tr><td><strong>" + newRowNumber
				+ "</strong></td>";
		var sudokuTableGrid = ${sudokuGrid}+"";
		var array = sudokuTableGrid.split(",")
		for (i = 1; i < 82; i++) {
			var rowLimit = i % 9;
			newRowContent = newRowContent + "<td>" + array[i - 1] + "</td>";
			if (rowLimit == 0) {
				newRowContent = newRowContent + "</tr>";
				$('#sudokuGrid tbody').append(newRowContent);
				newRowNumber = (i / 9) + 1;
				newRowContent = "<tr><td><strong>" + newRowNumber
						+ "</strong></td>";
			}
		}
	</script>
</body>
</html>
