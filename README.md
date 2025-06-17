# support-ticket-api

### 🧩 **Challenge 4: Support Ticket Management**

**Repository name:** `support-ticket-api`

#### 📌 Product Requirements:

Sistem ticket untuk layanan support:

- Pelanggan bisa buat dan melihat tiket
- Admin bisa menjawab dan update status tiket
- Tiket bisa diberi prioritas: LOW, MEDIUM, HIGH

#### 📡 Endpoints:

1. `POST /auth/register`
2. `POST /auth/login`
3. `POST /tickets`
4. `GET /tickets/my`
5. `GET /tickets/all` (ADMIN)
6. `PUT /tickets/{id}/respond` (ADMIN)
7. `PUT /tickets/{id}/status` (ADMIN)
8. `GET /tickets/{id}`

#### 🧾 Entities:

- **User** (id, email, password, role: CUSTOMER/ADMIN)
- **Ticket** (id, user_id, title, message, status, priority, response, created_at)

---

### ✅ Fitur Tambahan di Semua Soal:

- 🔐 JWT-based security
- ✅ Bean validation (misal `@NotBlank`, `@Size`, dll)
- 📦 DTO usage untuk request/response
- 📃 API tested via Postman (bonus)

Jika kamu ingin saya buatkan struktur folder, kode JWT-nya, atau request/response sample untuk salah satu dari challenge di atas, tinggal bilang ya!
