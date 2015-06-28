$(function() {

    var form = $('#ajaxform');
    var formMessages = $('#results');
    $(form).submit(function(eve) {

        eve.preventDefault();
        var formData = $(form).serialize();

        $.ajax({
                type: 'GET',
                url: $(form).attr('action'),
                data: formData
        })
        .done(function(response) {
                $(formMessages).removeClass('error');
                $(formMessages).addClass('success');
                $(formMessages).text(response);
        })
        .fail(function(data) {
                $(formMessages).removeClass('success');
                $(formMessages).addClass('error');

                if (data.responseText !== '') {
                        $(formMessages).text(data.responseText);
                } else {
                        $(formMessages).text('An error occured and the message could not be sent.');
                }
        });
    });
});

