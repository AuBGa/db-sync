<?php
namespace com\frasiek\dss;

/**
 * Klasa w PHP pozwalająca na połączenie z bazą danych
 * @author Michał Fraś <michal@frasiek.com>
 */
class DatabaseSchemaSynchronizer {

    /**
     * @var array
     */
    private $request;

    /**
     * @var string
     */
    private $status = "OK";

    /**
     * @var mixed
     */
    private $data;

    /**
     * Połączenie z bazą danych
     * @var \mysqli
     */
    private $db;

    const HOST = "host";
    const LOGIN = "login";
    const PASSWORD = "password";
    const PORT = "port";
    const SQL = "sql";
    const RETURN_TXT = "return";
    const INFORMATION_SCHEMA = "information_schema";

    public function handleRequest($post) {
        try {
            $this->request = $post;
            $this->checkNessasaryData();
            $this->connect();
            $this->runQuery();
        } catch (\Exception $ex) {
            $this->status = "ERROR";
            $this->data = $ex->getMessage();
        }
    }

    public function runQuery() {
        if ($this->getPart(self::RETURN_TXT) == '1') {
            $this->data = $this->getAll($this->getPart(self::SQL));
        } else {
            $this->query($this->getPart(self::SQL));
            if ($this->db->errno > 0) {
                throw new \Exception($this->db->error, $this->db->errno);
            }
            $this->data = $this->db->affected_rows;
        }
    }

    public function getAll($query) {
        $result = $this->db->query($query);
        if ($this->db->errno > 0) {
            throw new \Exception($this->db->error, $this->db->errno);
        }
        if (!$result || !($result instanceof \mysqli_result)) {
            return null;
        }
        $data = array();
        while ($tmp = $result->fetch_object()) {
            $data[] = $tmp;
        }
        $result->close();
        return $data;
    }

    private function checkNessasaryData() {
        $nessesaryKeys = array(
            self::HOST, self::LOGIN, self::PASSWORD, self::PORT, self::SQL, self::RETURN_TXT
        );
        foreach ($nessesaryKeys as $key) {
            if (!array_key_exists($key, $this->request)) {
                throw new \Exception("MISSING POST DATA: {$key}", 1);
            }
        }
    }

    private function connect() {
        $this->db = new \mysqli($this->getPart(self::HOST), $this->getPart(self::LOGIN), $this->getPart(self::PASSWORD), self::INFORMATION_SCHEMA, $this->getPart(self::PORT));
        if ($this->db->connect_errno > 0) {
            throw new \Exception($this->db->connect_error, $this->db->connect_errno);
        }
        $this->db->query("SET NAMES utf8");
        if ($this->db->errno > 0) {
            throw new \Exception($this->db->error, $this->db->errno);
        }
    }

    private function query($query) {
        $result = $this->db->query($query);
        if ($this->db->errno > 0) {
            throw new \Exception($this->db->error, $this->db->errno);
        }
        return $result;
    }

    private function getPart($part) {
        return $this->request[$part];
    }

    public function getStatus() {
        return $this->status;
    }

    public function getData() {
        return $this->data;
    }

}
header('Content-Type: text/html; charset=utf-8');
if (!isset($_POST)) {
    $_POST = array();
}

$databaseSchemaSynchronizer = new DatabaseSchemaSynchronizer();
$databaseSchemaSynchronizer->handleRequest($_POST);

$response = array(
    'status' => $databaseSchemaSynchronizer->getStatus(),
    'data' => $databaseSchemaSynchronizer->getData(),
);

echo json_encode($response);
