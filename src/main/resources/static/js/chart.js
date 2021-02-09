// font: https://www.chartjs.org/docs/latest/charts/doughnut.html

// Parse project x status data
var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

// Populate data to use in the chart
var numericData = [];
var labelData = [];

for (var i = 0; i < chartJsonArray.length; i++) {
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    // The type of chart we want to create
    type: 'pie',

    // Th e data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
        title: {
            display: true,
            text: "Project Status"
        }
    }
});

function decodeHtml(html) {
    var txt = document.createElement("textarea")
    txt.innerHTML = html;
    return txt.value;
}