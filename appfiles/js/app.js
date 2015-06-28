    var wordReversalForm = function() {

        var form = $('#ajaxform');
        var responseTag = $('#results');
        var doneFunc = function(response) {
                    $(responseTag).removeClass('error');
                    $(responseTag).addClass('success');
                    $(responseTag).text(response);
        }
        var failFunc = function(data) {
            $(responseTag).removeClass('success');
            $(responseTag).addClass('error');

            if (data.responseText !== '') {
                    $(responseTag).text(data.responseText);
            } else {
                    $(responseTag).text('An error occured and the message could not be sent.');
            }
        }
        eventFunc(form, responseTag, doneFunc, failFunc);

    }

    var plottingForm = function() {

        var form = $('#plottingform');
        var responseTag = $('#plotresults');

        var e = document.getElementById("function");
        var funStr = e.options[e.selectedIndex].text;



        var doneFunc = function(response) {

                    var jsonobj = JSON.parse(response);
                    var xlist =[];
                    var ylist =[];
                    for (index = 0; index < jsonobj.length; index++) {
                            xlist.push(jsonobj[index].x);
                            ylist.push(jsonobj[index].y);
                    }

                    $(responseTag).removeClass('error');
                    $(responseTag).addClass('success');

                    $(responseTag).highcharts({
                    title: {
                    text: 'Simple Function Plotting',
                    x: -20 //center
                    },
                    xAxis: {
                    title: {
                    text: 'X axis'
                    },
                    categories: xlist
                    },
                    yAxis: {
                    title: {
                    text: 'Y axis'
                    },
                    plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                               }]
                    },
                    tooltip: {
                    valueSuffix: 'm/s^2'
                             },
                    legend: {
                    layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'middle',
                            borderWidth: 0
                            },
                    series: [{
                          name: funStr,
                          data: ylist
                          }]
                });

        }
        var failFunc = function(data) {
            $(responseTag).removeClass('success');
            $(responseTag).addClass('error');

            if (data.responseText !== '') {
                    $(responseTag).text(data.responseText);
            } else {
                    $(responseTag).text('An error occured and the message could not be sent.');
            }
        }
        eventFunc(form, responseTag, doneFunc, failFunc);

    }

    var ajaxFunction = function() {
        wordReversalForm();
        plottingForm();
    }


$(ajaxFunction);

