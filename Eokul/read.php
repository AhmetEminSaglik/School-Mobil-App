<?php
header('Content-Type: application/json');
$data = array();
$id=$_POST['id'];
$con = mysqli_connect('localhost', 'root', '', 'crud');
if ($con) {
    $sql = "SELECT * from crud_table where id=".$id;
    $result = mysqli_query($con, $sql);
    if (mysqli_num_rows($result) != 0) {
        $i = 0;
        while ($row = mysql_fetch_assoc($result)) {
            $data[$i] = $row;
            $i++;
        }
        echo json_encode($data, JSON_PRETTY_PRINT);
    }

}else echo "Failed to connect database";
