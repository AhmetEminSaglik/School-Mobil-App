<?php
header('Content-Type: application/json');
$servername = "localhost";
$username = "root";
$password = "";

try {
    $conn = new PDO("mysql:host=$servername;dbname=Eokul", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // POST isteğinden gelen parametreleri al
    $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
    $surname = filter_input(INPUT_POST, 'surname', FILTER_SANITIZE_STRING);
    $tc_kn = filter_input(INPUT_POST, 'tc_kn', FILTER_VALIDATE_INT);
    $parentName = filter_input(INPUT_POST, 'parentName', FILTER_SANITIZE_STRING);
    $no = filter_input(INPUT_POST, 'no', FILTER_VALIDATE_INT);

    // Parametrelerin varlığını kontrol et
    if (!empty($name) && !empty($surname) && $tc_kn !== false && !empty($parentName) && $no !== false) {

        $sql = "UPDATE student SET name = :name, surname = :surname, tc_kn = :tc_kn, parentName = :parentName, no=:no WHERE no = :no";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':name', $name, PDO::PARAM_STR);
        $stmt->bindParam(':surname', $surname, PDO::PARAM_STR);
        $stmt->bindParam(':tc_kn', $tc_kn, PDO::PARAM_INT);
        $stmt->bindParam(':parentName', $parentName, PDO::PARAM_STR);
        $stmt->bindParam(':no', $no, PDO::PARAM_INT);
        $stmt->execute();

        // Başarılı mesajını JSON formatında yazdır
        echo json_encode("Success");
    } else {
        echo "Invalid or missing parameters";
    }
} catch (PDOException $e) {
    echo "Connection error: " . $e->getMessage();
}

$conn = null;

