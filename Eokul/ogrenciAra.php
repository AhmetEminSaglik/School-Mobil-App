<?php
header('Content-Type: application/json');
$data = array();
$con = mysqli_connect('localhost', 'root', '', 'Eokul');

if (!$con) {
    echo "Veritabanına bağlanılamadı.";
    exit;
}

// "no" anahtarı var mı kontrol et
if(isset($_POST['no'])) {
    $no = $_POST['no'];
        error_log("Received 'no' value: " . $no); // Log ekleyin


    // SQL sorgusunu düzenle, student tablosunu kullan
    $sql = "SELECT name, surname FROM student WHERE no = ?";

    $stmt = mysqli_prepare($con, $sql);

    if ($stmt) {
        mysqli_stmt_bind_param($stmt, "i", $no);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);

        if ($result) {
            $row = mysqli_fetch_assoc($result);
            if ($row) {
                echo json_encode($row, JSON_PRETTY_PRINT);
            } else {
                echo "Kayıt bulunamadı.";
            }
        } else {
            echo "Sorgu çalıştırma hatası: " . mysqli_error($con);
        }

        mysqli_stmt_close($stmt);
    } else {
        echo "Statement oluşturma hatası.";
    }
} else {
    echo "Post verisi içinde 'no' anahtarı bulunamadı.";
}

mysqli_close($con);
?>
