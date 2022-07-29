package storage;

import exception.StorageException;
import model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

// TODO: Дописать реализацию абстракстного класса

public abstract class AbstractPathStorage extends AbstractStorage<Path> {

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    private final Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new StorageException("is not directory or is not writable", null);
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        //TODO
        return null;
    }

    @Override
    protected List<Resume> doCopyAll() {
        //TODO
        return null;
    }

    @Override
    protected void doSave(Resume r, Path path) {
        //TODO
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        //TODO
    }

    @Override
    protected Resume doGet(Path path) {
        //TODO
        return null;
    }

    @Override
    protected boolean isExist(Path path) {
        //TODO
        return true;
    }

    @Override
    protected void doDelete(Path path) {
        //TODO
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}

