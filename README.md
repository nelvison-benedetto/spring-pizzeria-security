## Spring Pizzeria Security
output:

Project developed using Java Spring Boot to manage pizzas, ingredients, reviews, and special offers with full CRUD operations. It follows the MVC architecture and uses Spring Data JPA with One-to-Many and Many-to-Many relationships for efficient data management. The UI is built with Thymeleaf, using modular fragments for maintainability. Advanced filtering allows searches by name, ingredients, and dietary preferences (gluten-free, vegetarian, halal). The application includes a services layer to handle business logic separately from controllers and provides REST API controllers for external interaction. Data is pre-populated using seeder classes with DataFaker, and the project is managed with Maven 🛰️.

## 🔐 Authentication & Authorization

To ensure secure access to the pizzeria management system, **authentication and authorization** have been implemented using **Spring Security**. The system restricts access to specific pages based on user roles, allowing only authorized users to perform actions that modify the data.

### User Roles:
- **USER**: Users with this role can only access the home page and view pizza details. They are restricted from performing any actions that modify the data.
- **ADMIN**: Users with this role have full access, including the ability to create, edit, and delete pizzas, ingredients, reviews, and special offers.

### Implementation:
- The necessary **entity models** for users and roles have been created.
- The database is **manually populated** with user data to ensure proper role assignments.
- **Spring Security** is used to manage authentication, and the application enforces role-based access control.

This approach ensures that only registered users with appropriate roles can interact with the system beyond the public pages, maintaining the integrity and security of the pizzeria's data.


![Reference1](./readmefiles/securityAdminIndex.png)
![Reference1](./readmefiles/securityAdminPizzasIndex.png)
![Reference1](./readmefiles/securityNoAdminIndex.png)
![Reference1](./readmefiles/securityNoAdminPizzasIndex.png)