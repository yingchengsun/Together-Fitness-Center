window.onload = function showtable() {
        var tablename = document.getElementById("mytable");
        var tabletr = tablename.getElementsByTagName("tr");
        for (var i = 0; i <= tabletr.length; i++) {
            if (i % 2 == 0) {
                tabletr[i].style.backgroundColor = "#CCCCCC";
            } else tabletr[i].style.backgroundColor = "#FFFFFF";
        }
    }