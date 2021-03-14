package com.mahim.jokesapp.impl;

import com.mahim.jokesapp.service.JokesService;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesServiceImpl implements JokesService {

    ChuckNorrisQuotes chuckNorrisQuotes;

    public JokesServiceImpl() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getJokes() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
