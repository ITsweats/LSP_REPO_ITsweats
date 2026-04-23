Part 1:
shared resource 1: nextId
shared resource 2: requests

concurrency problem:
A race condition may occur. Multiple threads could get the same nextId, skip IDs, or corrupt the shared ArrayList.

Why addRequest() is unsafe:
addRequest() reads and updates shared data without synchronization. It calls getNextId() and modifies requests, so multiple threads can interfere with each other.

Part 2:
Fix A: Correct for ID generation only.
Synchronizing getNextId() prevents duplicate or skipped IDs because only one thread can update nextId at a time. However, requests.add(request) is still unsafe because ArrayList is shared and not thread-safe.

Fix B: Correct.
Synchronizing addRequest() protects both ID generation and adding to the list. Only one thread can run the full request-creation process at a time.

Fix C: Not correct.
Synchronizing getRequests() only protects access when returning the list. It does not protect nextId or requests.add() inside addRequest().

Part 3:
No, getNextId() should not be public.It exposes an internal implementation detail. Based on Arthur Riel’s heuristics, classes should hide data and behavior that outside code does not need. Request IDs should be managed internally by RequestManager.

part 4:

src.org.howard.edu.lsp.finalexam.question1.doc
private final ReentrantLock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = getNextId();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        lock.unlock();
    }
}