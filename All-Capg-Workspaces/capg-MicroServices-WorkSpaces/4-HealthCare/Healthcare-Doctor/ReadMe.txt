BASE URL
http://localhost:8080/doctor


1️⃣ ADD DOCTOR
Method: POST
URL:
http://localhost:8080/doctor/add

Body (raw JSON):
{
  "doctorId": 1,
  "name": "Dr. Rajesh",
  "specialization": "Cardiologist",
  "hospital": "Apollo Hospital",
  "phone": "9876543210"
}



2️⃣ GET ALL DOCTORS
Method: GET
URL:
http://localhost:8080/doctor/getall

Body:
No body required



3️⃣ GET DOCTOR BY ID
Method: GET
URL:
http://localhost:8080/doctor/get/1

Body:
No body required



4️⃣ UPDATE DOCTOR
Method: PUT
URL:
http://localhost:8080/doctor/update/1

Body (raw JSON):
{
  "name": "Dr. Rajesh Kumar",
  "specialization": "Neurologist",
  "hospital": "AIIMS",
  "phone": "9999999999"
}



5️⃣ DELETE DOCTOR
Method: DELETE
URL:
http://localhost:8080/doctor/delete/1

Body:
No body required