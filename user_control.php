<?php 

    require_once 'connection.php';
    header('Content-Type: application/json ');  

    class User {
        
        private $db;
        private $connection;
        
        function __construct(){
            
            $this->db = new DB_Connection();
            //$this->connection = $this->db->get_connection();
            $this->connection= mysqli_connect('localhost','root', '', 'movies') or die(" DB connection error");
            
            
        }
        
     
       
        public function does_user_exist($username,$password) {
            
            $username='juan';
            $password='yfz';
            $query = "Select * from users where username ='$username' and password= '$password' ";
            $result= mysqli_query($this->connection, $query);
            
            /*if(mysqli_num_rows($result) > 0){       
                $json['success'] = 'user already in database'.$username;     // means record has been found
                echo json_encode($this->connection);
                
                
            }else {
             */
                 $query = "Insert into users(username,password) values ('$username','$password')";
                 
                  $is_inserted= mysqli_query($this->connection, $query);
                 if ($is_inserted == 1 ){
                  
                     $json['success'] = 'Account created, Welcome'.$username;
                     
                 } else{
                  
                     $json['error'] = ' Wrong Password' ;
                 }  
                 
                 echo json_encode($json);
                 mysqli_close($this->connection);
                 
              
           // }
              
                
        }
        
   }
        $user = new User();
        if (isset($_POST['username'],$_POST['password'])){
            $username = $_POST['username'];
            $password = $_POST['password'];
            
            if (!empty($username) && !empty($password) ){
                
                
                
                //$encrypted_password = md5($password);
                //$user-> does_user_exist($username,$encrypted_password);
                
                $db = new DB_Connection();
                //$this->connection = $this->db->get_connection();
                $connection= mysqli_connect('localhost','root', '', 'movies') or die(" DB connection error");
                
                $query = "Insert into users(username,password) values ('$username','$password')";
                
                $is_inserted= mysqli_query($connection, $query);
                if ($is_inserted == 1 ){
                    
                    $json['success'] = 'Account created, Welcome'.$username;
                    
                } else{
                    
                    $json['error'] = ' Wrong Password' ;
                }
                
                echo json_encode($json);
                mysqli_close($connection);
                
            } else {
                   echo json_encode(" You must fill all fields");
                   
           
            }
            
            
        }
        
        
        

?>