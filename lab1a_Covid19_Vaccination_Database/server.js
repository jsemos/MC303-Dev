//server.js file create to launch Node JS server and processes
const port = 3000;
var favicon = require('serve-favicon');
const express = require('express');
const fs = require('fs');
const path = require('path');
const app = express();

//serve app favicon
app.use(favicon(path.join(__dirname, 'assets', 'favicon.ico')));

//middleware to parse
app.use('/css', express.static('css'));
app.use('/js', express.static('js'));
app.use('/assets', express.static('assets'));
app.use(express.urlencoded({extended: true}));

//serve HTML form
app.get('/', function(reg, res) {
    res.sendFile(path.join(__dirname + '/index.html'));
});

//form handler
app.post('/submit', (req, res) => {
    const { FirstnameTxt, SurnameTxt, AgeSlider, PoVaccinationTxt, selectchoice1, selectchoice2, dateofDose1, dateofDose2, selectchoice3, selectchoice4 } = req.body;

    const data = `First name: ${FirstnameTxt}, Surname: ${SurnameTxt}, Age: ${AgeSlider}, Place of Vaccination: ${PoVaccinationTxt}, Type of Vaccination: ${selectchoice1}, 
    Name of Vaccine Manufacturer: ${selectchoice2}, Date of Dose 1: ${dateofDose1}, Date of Dose 2: ${dateofDose2}, 
        Healthcare Professional ID: ${selectchoice3}, Healthcare Professional Fullname: ${selectchoice4}\n\n`;

    //append data to sample.txt file in the assets folder
    fs.appendFile('assets/sample.txt', data, (err) => {
        if(err) {
            console.log(err);
            return res.status(500).send("There was an error saving record to the file!")
        }
        res.send('Record successfully saved to the file!');
        console.log("Record successfully saved to the file!");
    });
});
 
//read data from sample.txt file in the assets folder
app.get('/read', (req, res) =>{
    fs.readFile('assets/sample.txt', 'utf8' , (err, data) => {
    if (err) {
        console.error(err);
        return res.status(500).send('There was an error reading records from the file');
    }
    res.send(`<pre>${data}</pre>`); //display data inside <pre> tag 
    console.log("Records read successfully from the file... it reads " + data);
    });
});

//start the server
app.listen(port, function(error) {
    if (error) {
        console.log('Something went wrong ', error);
    } else {
        console.log('Local Server is up on port: ' + port);
    }
});