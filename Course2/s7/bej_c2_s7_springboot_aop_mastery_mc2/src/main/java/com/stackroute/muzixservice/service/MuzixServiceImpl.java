package com.stackroute.muzixservice.service;


/*
 * Service classes are used here to implement additional business logic/validation
 * This class has to be annotated with @Service annotation.
 * @Service - It is a specialization of the component annotation. It doesn't currently
 * provide any additional behavior over the @Component annotation, but it's a good idea
 * to use @Service over @Component in service-layer classes because it specifies intent
 * better. Additionally, tool support and additional behavior might rely on it in the
 * future.
 * */

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import com.stackroute.muzixservice.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MuzixServiceImpl implements  MuzixService{

    /*
     * Autowiring should be implemented for the MuzixRepository. (Use
     * Constructor-based autowiring) Please note that we should not create any
     * object using the new keyword.
     */
    @Autowired(required = true)
    private MuzixRepository muzixRepository;

    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }
    /*
     * This method should be used to save a new track.Call the corresponding
     * method of Respository interface.
     */
    @Override
    public Track SaveTrackToWishList(Track track) throws TrackAlreadyExistsException {
        if(muzixRepository.findById(track.getTrackId()).isEmpty()){
            muzixRepository.insert(track);
            return track;
        }
        else{
            throw new TrackAlreadyExistsException();
        }
    }

    /*
     * This method should be used to delete an existing track.Call the
     * corresponding method of Respository interface.
     */

    @Override
    public boolean deleteTrackFromWishList(String id) throws TrackNotFoundException {
        if(muzixRepository.findById(id).isEmpty()){
            throw new TrackNotFoundException();
        }
        else{
            muzixRepository.deleteById(id);
            return true;
        }
    }

    /*
     * This method should be used to update a existing track.Call the
     * corresponding method of Respository interface.
     */

    @Override
    public Track updateCommentForTrack(String comments, String id) throws TrackNotFoundException {
        if(muzixRepository.findById(id).isEmpty()){
            throw new TrackNotFoundException();
        }
        else{
            Track t=muzixRepository.findById(id).get();
//            t.setComments(comments);
            Track t1=new Track(t.getTrackId(),t.getTrackName(),comments,t.getTrackListeners(),t.getTrackUrl(),t.getArtist());
            muzixRepository.save(t1);
            return t1;
        }
    }

    @Override
    public List<Track> getAllTracksByArtistName(String artistName) throws TrackNotFoundException {
        List<Track> list= muzixRepository.getAllTracksByArtistName(artistName);
        return list;
    }

    /*
     * This method should be used to get all track.Call the corresponding
     * method of Respository interface.
     */

    @Override
    public List<Track> getAllTrackFromWishList() throws Exception {
        List<Track> list=muzixRepository.findAll();
        return list;
    }
}
