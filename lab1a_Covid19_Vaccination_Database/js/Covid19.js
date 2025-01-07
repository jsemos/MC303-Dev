//create on click event function to ahref
$('a').click(function(e){
	e.preventDefault();
});

//form submission to file function
 function submitForm(event) {
	event.preventDefault();

	const formData = new FormData(document.querySelector('form'));
	const data = new URLSearchParams(formData);

	fetch('/submit', {
	  method: 'POST',
	  body: data
	})
	.then(response => response.text())
	.then(responseText => {
	  alert(responseText);
	})
	.catch(error => {
	  console.error('Error:', error);
	});
  }

 //read from file function 
  function readFromFile() {
	fetch('/read')
	  .then(response => response.text())
	  .then(data => {
		document.getElementById('fileContents').innerHTML = data;
	  })
	  .catch(error => {
		console.error('Error:', error);
	  });
  }