<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
session="false" %>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

        <form action="/api/deptjson" method="post">
            <input type="text" name="deptno" placeholder="deptno" id="deptno" />
            <input type="text" name="dname" placeholder="dname" id="dname" />
            <input type="text" name="loc" placeholder="loc" id="loc" />

            <button type="button" id="btn">push</button>
        </form>

        <!-- <script>
            axios
                .get("http://localhost:8080/jdbc/api/depts")
                .then((response) => console.log(response.data));
        </script> -->
        <!-- <script>
            axios
                .post("http://localhost:8080/jdbc/api/deptjson", {
                    deptno: 100,
                    dname: "FRONTEND",
                    loc: "JEJU",
                })
                .then((response) => console.log(response));
        </script> -->

        <script>
             const url = "http://localhost:8080/jdbc/api/depts";
            const params = new URLSearchParams();
            params.append("deptno", 211);
            params.append("dname", "test");
            params.append("loc", "test");
            // // 추가된 부분
            const axiosConfig = {
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
            };

            axios
                .get(url, params, axiosConfig)
                .then((res) => {
                    console.log(res);
                })
                .catch((error) => {
                    console.log(error.response);
                });

            let deptno = document.getElementById("deptno");
            let dname = document.getElementById("dname");
            let loc = document.getElementById("loc");
            let btn = document.getElementById("btn");
            btn.addEventListener("click", () => {
                console.log(deptno.value);
                let data = {
                    deptno: deptno.value,
                    dname: dname.value,
                    loc: loc.value,
                };
                axios.post(url, data);
            });

            document.addEventListener("DOMContentLoaded", function () {
            	
                axios
                    .get("http://localhost:8080/jdbc/api/depts")
                    .then((response) => {
                        response.data.forEach((element) => {
                            /* console.log(element.deptno);
                            console.log(element.dname);
                            console.log(element.loc); */
                            /* document.body.innerHTML = element.deptno; */
                            /* document.writeln(element.deptno);
                             document.writeln(element.dname); 
                             document.writeln(element.loc); */
                        });
                    });
            });
        </script>

        <!-- ${requestScope.deptno} <br />
        <p>dname :${requestScope.dname}</p>
        <p>dname :${requestScope.dname1}</p>
        <p>dname :${rent.getElementById("btn");
equestScope.alldept}</p> -->
    </body>
</html>
