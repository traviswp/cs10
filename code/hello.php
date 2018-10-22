<?

if (isset($_GET['color'])) {
    echo "Hi there, " . $_GET['name'] . ", thanks for stopping by! " . $_GET['color'] . " is my favorite color too!";
} else{
    echo "Hi there, " . $_GET["name"] . ", thanks for stopping by!";
}

?>
