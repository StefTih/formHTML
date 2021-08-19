<!--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>-->

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fill in form</title>
</head>
<body>
<h1> Fill in the details</h1><br>

<form action="formServlet" method="post" onsubmit="check()">
    Enter your first name: <input type="text" name="firstName" required><br><br>
    Enter your last name: <input type="text" name="lastName" required><br><br>
    Enter your email: <input type="text" name="email" required><br><br>
    Enter gender:
    <select name="gender" id="gender">
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
    </select><br><br>
    Enter your job description: <input type="text" name="jobDescription" required><br><br>
    Enter your password: <input type="password" name="password" id="passwordId" required minlength="8" ><br><br>
    Repeat password: <input type="password" name="password2" id="passwordId2" required minlength="8"><br><br>
    <script language="javascript" type="text/javascript">
        function check() {
            let p1 = document.getElementById("passwordId");
            let p2 = document.getElementById("passwordId2");
            console.log(p1);
            console.log(p2);

            if (p1 != p2){
                alert("Passwords did not match!");
                event.preventDefault();
                window.history.back();
            }
        }
    </script>
    <input type="submit" value="submit">
</form>
</body>
</html>