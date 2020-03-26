var apiclient =apiclient;
var app=( function () {


    var _map=function (list) {
        return mapping=list.map(function (country) {
                return {
                    country: country.country, deaths: country.deaths, recovered: country.recovered, confirmed: country.confirmed
                };
            }

        )

    }

    var table= function () {
        apiclient.getAllCases(createTable);

    }

    var createTable=function (countries) {
        countries=_map(countries);
        $("#table > tbody").empty();
        countries.map(function(c){

            $("#table > tbody").append(
                "<tr> <td>" +

                c.country +
                "</td>" +
                "<td>" +
                c.confirmed +
                "</td> " +
                "<td>" +
                c.recovered +
                "</td> "+
                "<td>" +
                c.deaths+
                "</td> "+
                "</tr>"
            );
        });

    }
    return{
        createTable:createTable,
        table:table
    }

})();