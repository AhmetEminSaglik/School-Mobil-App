<?php
header('Content-Type: application/json');
$data = array();
$con = mysqli_connect('localhost', 'root', '', 'Eokul');
/**
 * @param mysqli $con
 * @param $sql
 * @param array $data
 * @return void
 */
function extracted(mysqli $con, $sql, array $data)
{
    $result = mysqli_query($con, $sql);

    if ($result) {
        if (mysqli_num_rows($result) > 0) {
            $i = 0;
            while ($row = mysqli_fetch_assoc($result)) {
                $data[$i] = $row;
                $i++;
            }
            echo json_encode($data, JSON_PRETTY_PRINT);
        } else {
            echo "No records found.";
        }
    } else {
        echo "Query execution failed: " . mysqli_error($con);
    }

    mysqli_close($con);
}

if ($con) {
    // SQL sorgusunu düzenle, headmaster tablosunu kullan
    $sql = "SELECT name, surname, no, password, tc_kn, parentName FROM student";

    extracted($con, $sql, $data);
} else {
    echo "Failed to connect database";
}

