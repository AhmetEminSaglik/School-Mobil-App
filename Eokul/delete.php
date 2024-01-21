<?php
header('Content-Type: application/json');
$servername = "localhost";
$username = "root";
$password = "";

try {
    $conn = new PDO("mysql:host=$servername;dbname=Eokul", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // POST isteğinden gelen parametreleri al
    $no = filter_input(INPUT_POST, 'no', FILTER_VALIDATE_INT);

    // Parametrelerin varlığını kontrol et
    if (!empty($no)) {

        $sql = "DELETE from student WHERE no = :no";
        $stmt = $conn->prepare($sql);
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

