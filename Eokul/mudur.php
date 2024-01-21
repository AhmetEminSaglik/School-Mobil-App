<?php
 header('Content-Type: application/json');
$servername = "localhost";
$username = "root";
$password = "";

try {
    $conn = new PDO("mysql:host=$servername;dbname=Eokul", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // "no" parametresini al

    $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);


    // "no" parametresinin varlığını kontrol et
    if ($name !== false) {

        $sql = "SELECT name, password FROM headmaster WHERE name =:name" ;
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':name', $name, PDO::PARAM_STR);
        $stmt->execute();
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        // Sonucu JSON formatında yazdır
        echo json_encode($result);
    } else {
        echo "Gecersiz veya eksik 'name' parametresi";
    }
} catch (PDOException $e) {
    echo "Bağlantı hatası: " . $e->getMessage();
}

$conn = null;
?>
