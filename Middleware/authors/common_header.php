<?php
/**
 * Created by PhpStorm.
 * User: mahsyaj
 * Date: 14/12/2018
 * Time: 09:17
 */

require_once "../common_config.php";

$dbManager = new AuthorDbManager();

$id = AuthorDbManager::FIELDS[0];
$name = AuthorDbManager::FIELDS[1];
$update = AuthorDbManager::FIELDS[2];