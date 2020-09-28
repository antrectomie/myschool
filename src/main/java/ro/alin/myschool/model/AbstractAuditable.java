package ro.alin.myschool.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

    @MappedSuperclass
    public class AbstractAuditable {
        protected String createdBy;
        @Type(type = "org.hibernate.type.LocalDateTimeType")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        protected LocalDateTime created;

        protected String lastUpdateBy;
        @Type(type = "org.hibernate.type.LocalDateTimeType")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        protected LocalDateTime lastUpdate;

        @PrePersist
        public void addCreatedBy() {
            this.createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
            this.created = LocalDateTime.now();
            this.lastUpdateBy = SecurityContextHolder.getContext().getAuthentication().getName();
            this.lastUpdate = LocalDateTime.now();
        }

        @PreUpdate
        public void addLastUpdateBy(){
            if(SecurityContextHolder.getContext().getAuthentication().getName() != null){
                this.lastUpdateBy = SecurityContextHolder.getContext().getAuthentication().getName();
                this.lastUpdate = LocalDateTime.now();
            }
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public LocalDateTime getCreated() {
            return created;
        }

        public void setCreated(LocalDateTime created) {
            this.created = created;
        }

        public String getLastUpdateBy() {
            return lastUpdateBy;
        }

        public void setLastUpdateBy(String lastUpdateBy) {
            this.lastUpdateBy = lastUpdateBy;
        }

        public LocalDateTime getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
        }

}
