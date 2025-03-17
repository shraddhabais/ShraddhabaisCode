This Spring Boot application calculates **customer reward points** based on their purchases over a three-month period.  

Features
-  REST API to calculate Rewards points for each customer
-  Stores Customers details &  transactions in an H2 in-memory database
-  Customizable period for reward calculations
   
Installation & Setup

1) Clone the Repository

git clone https://github.com/your-repo/rewards.git
cd rewards

2) Build and Run 
mvn clean install
mvn spring-boot:run

3)H2 Database Console
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave empty)

 API Endpoints
1. Get Reward Points (Last 3 Months)
GET /api/rewards/{customerId}
Default: Returns rewards for the last 3 months.

 Example Request:

1) GET "http://localhost:8080/api/rewards?customerId=1

 Response :
{
  "customerId": 1,
  "customerName": "Jonny",
  "transactions": [
    {
      "month": "FEBRUARY 2025",
      "totalAmount": 100.0,
      "rewardPoints": 50
    },
    {
      "month": "JANUARY 2025",
      "totalAmount": 200.0,
      "rewardPoints": 250
    }
  ],
  "totalRewardPoints": 300
}



2) GET  http://localhost:8080/api/rewards?customerId=1&months=5
Response :

 {
  "customerId": 1,
  "customerName": "Jonny",
  "transactions": [
    {
      "month": "DECEMBER 2024",
      "totalAmount": 120.5,
      "rewardPoints": 91
    },
    {
      "month": "NOVEMBER 2024",
      "totalAmount": 75.0,
      "rewardPoints": 25
    },
    {
      "month": "FEBRUARY 2025",
      "totalAmount": 100.0,
      "rewardPoints": 50
    },
    {
      "month": "JANUARY 2025",
      "totalAmount": 200.0,
      "rewardPoints": 250
    }
  ],
  "totalRewardPoints": 416
}


3) Endpoints to fetch all customers
 GET  http://localhost:8080/api/rewards/customers
 Response :
 
 [
  {
    "id": 1,
    "name": "Jonny"
  },
  {
    "id": 2,
    "name": "Ronny"
  },
  {
    "id": 3,
    "name": "Bobby"
  }
]


