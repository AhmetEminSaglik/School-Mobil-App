<?php
 header('Content-Type: application/json');
$servername = "localhost";
$username = "root";
$password = "";

try {
    $conn = new PDO("mysql:host=$servername;dbname=Eokul", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // "no" parametresini al

    $no = filter_input(INPUT_POST, 'no', FILTER_VALIDATE_INT);


    // "no" parametresinin varlığını kontrol et
    if ($no !== false) {

        $sql = "SELECT name, surname FROM student WHERE no =:no" ;
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':no', $no, PDO::PARAM_INT);
        $stmt->execute();
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        // Sonucu JSON formatında yazdır
        echo json_encode($result);
    } else {
        echo "Gecersiz veya eksik 'no' parametresi";
    }
} catch (PDOException $e) {
    echo "Bağlantı hatası: " . $e->getMessage();
}

$conn = null;
?>
