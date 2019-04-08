<?php
/**
 * Created by PhpStorm.
 * User: mahsyaj
 * Date: 14/12/2018
 * Time: 09:13
 */

require_once "common_header.php";

if (isset($_POST[$idUser]) && isset($_POST[$idBook]) && isset($_POST[$review]) && isset($_POST[$shared])) {
    $response_code = ($dbManager->create($_POST[$idUser], $_POST[$idBook], $_POST[$review], $_POST[$shared])) ? 201 : 404;
} else if (isset($_POST[$idUser]) && isset($_POST[$idBook]) && isset($_POST[$review])) {
    $response_code = ($dbManager->create($_POST[$idUser], $_POST[$idBook], $_POST[$review])) ? 201 : 404;
} else {
    $response_code = 400;
}

http_response_code($response_code);