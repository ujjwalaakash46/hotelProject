
# Hotel Project

Project to manage Hotels, Users and their reviews.
(Added Sample Hotel and Users).

filter hotels by any field or add review to a hotel.
and with pagination on list APIs
 
Using H2 Database for the easiness to test the project.

To run: Start as Spring boot Project.




## API Reference

#### Get all Hotel

```http
  GET /hotel/get
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `page` | `int` | Page number |
| `size` | `int` | Page size |

#### Get Hotel

```http
  GET /hotel/get
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Id of the hotel |

#### Add Hotel

```http
  POST /hotel/add
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `hotel` in body       | `Hotel` | hotel object |

#### Add review to hotel

```http
  POST /hotel/add/review
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `user`      | `int` | user id |
| `hotel`      | `int` | hotel id |
| `rating`      | `int` | rating given by the user |
| `Comment` in body       | `String` | Comment by the user |

#### Find Hotels by a field

```http
  GET /hotel/find
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `field`      | `String` | field of hotel to be searched by  |
| `value`      | `String` | value of the field |
| `page` | `int` | Page number |
| `size` | `int` | Page size |

#### Delete hotel by id

```http
  DELETE /hotel/delete
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Id of the hotel |

#### Get All Users

```http
  GET /user
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `page` | `int` | Page number |
| `size` | `int` | Page size |

#### Get user by id

```http
  GET /user/get
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Id of the user |


#### Add User

```http
  POST /user/add
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `user` in body       | `User` | User object |


#### Delete user by id

```http
  DELETE /user/delete
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Id of the user |
