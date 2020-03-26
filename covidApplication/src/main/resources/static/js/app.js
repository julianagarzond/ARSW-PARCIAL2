var apiclient =apiclient;
var app=( function () {

    var _countryName;


    var _map= function (list) {
        return mapping=list.map(function (country) {
                return {
                   keyId:country.keyId, country: country.country, deaths: country.deaths, recovered: country.recovered, confirmed: country.confirmed
                };
            }

        )

    }

    var countryInfo=function (country) {
        $("#table2 > tbody").empty();
        country.map(function(c) {

            $("#table2 > tbody").append(
                "<tr> <td>" +

                c.keyId+
                "</td>" +
                "<td>" +
                c.confirmed +
                "</td> " +
                "<td>" +
                c.recovered +
                "</td> " +
                "<td>" +
                c.deaths +
                "</td> " +

                "</tr>"
            )
        });


    }



    var table= function () {
        apiclient.getAllCases(createTable);

    }

    var table2=function (name) {
            apiclient.getCasesByCountry(name,countryInfo);
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
                "<td action='info.html'><form ><button type='submit' onclick='app.countryInfo(\"" +
                c.country+ "\""+ ")'> select</button></form></td>" +
                "</tr>"
            );
        });

    }








    return{
        createTable:createTable,
        table:table,
        countryInfo:countryInfo,
        table2:table2
    }

})();