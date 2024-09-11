package net.newlearning.journalApp.Repository;

import net.newlearning.journalApp.Entity.JournalEntry;
import net.newlearning.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    void deleteByUserName(String username);


    User findByUserName(String userName);
}
