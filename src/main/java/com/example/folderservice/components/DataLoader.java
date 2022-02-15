package com.example.folderservice.components;

import com.example.folderservice.models.File;
import com.example.folderservice.models.Folder;
import com.example.folderservice.models.User;
import com.example.folderservice.repositories.FileRepository;
import com.example.folderservice.repositories.FolderRepository;
import com.example.folderservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        User user1 = new User("Maike");
        userRepository.save(user1);
        User user2 = new User ("Bob");
        userRepository.save(user2);

        Folder folder1a = new Folder("Folder 1A", user1);
        Folder folder1b = new Folder("Folder 1B", user1);
        Folder folder2a = new Folder("Folder 2A", user2);
        Folder folder2b = new Folder("Folder 2B", user2);
        folderRepository.save(folder1a);
        folderRepository.save(folder1b);
        folderRepository.save(folder2a);
        folderRepository.save(folder2b);



        File file1 = new File("File 1", ".js", 100,folder1a);
        File file2 = new File("File 2", ".js", 100,folder1b);
        File file3 = new File("File 3", ".js", 100,folder2a);
        File file4 = new File("File 4", ".js", 100,folder2b);
        fileRepository.save(file1);
        fileRepository.save(file2);
        fileRepository.save(file3);
        fileRepository.save(file4);

        folder1a.addToFolder(file1);
        folder1b.addToFolder(file2);
        folder2a.addToFolder(file3);
        folder2b.addToFolder(file4);
        folderRepository.save(folder1a);
        folderRepository.save(folder1b);
        folderRepository.save(folder2a);
        folderRepository.save(folder2b);

        user1.addFolder(folder1a);
        user1.addFolder(folder1b);
        user2.addFolder(folder2a);
        user2.addFolder(folder2b);
        userRepository.save(user1);
        userRepository.save(user2);

    }
}
