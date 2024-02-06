package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;
@Entity


public class AbstractEntity {




        @Id
        @GeneratedValue
        private int id;
        private static int nextId = 1;
        @NotBlank
        @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
        private String name;
        @Size(max = 500, message = "Description too long!")
        private String description;

        @Email(message = "Invalid email. Try again.")
        private String contactEmail;

        private EventType type;



        public AbstractEntity(String name, String description, String contactEmail, EventType type) {
            this();
            this.name = name;
            this.description = description;
            this.contactEmail = contactEmail;
            this.type = type;

        }
        public AbstractEntity() {
            this.id = nextId;
            nextId++;
        }
        public EventType getType() {
            return type;
        }

        public void setType(EventType type) {
            this.type = type;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        @Override
        public String toString() {
            return name;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

