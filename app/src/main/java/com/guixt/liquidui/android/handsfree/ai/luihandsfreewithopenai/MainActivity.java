package com.guixt.liquidui.android.handsfree.ai.luihandsfreewithopenai;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageButton button;
    private RecyclerView recyclerView;
    private ResponseAdapter adapter;
    private List<ChoiceEntity> responseList = new ArrayList<>();
    private AppDatabase db;
    private SharedPrefManager sharedPrefManager;
    private OpenAIApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ResponseAdapter(responseList);
        recyclerView.setAdapter(adapter);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        sharedPrefManager = new SharedPrefManager(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sendRequest("You will always respond with json first key as 'action', second key 'mood' for all further questions without fail");

        api = retrofit.create(OpenAIApi.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        loadChoices();

        // Add a global layout listener to detect when the keyboard is shown
        findViewById(android.R.id.content).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                findViewById(android.R.id.content).getWindowVisibleDisplayFrame(r);
                int screenHeight = findViewById(android.R.id.content).getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;

                if (keypadHeight > screenHeight * 0.15) { // If more than 15% of the screen height is covered by the keyboard
                    if (responseList.size() > 0) {
                        recyclerView.smoothScrollToPosition(responseList.size() - 1);
                    }
                }
            }
        });

        // Pre-programming the assistant
        //sendPreProgrammingRequest("You will always respond with JSON first key as 'action', second key 'mood' for all further questions without fail");


    }

    private void sendRequest() {
        final String inputText = editText.getText().toString();
        sendRequest(inputText);
    }

    private void sendPreProgrammingRequest(String inputText) {
        if (inputText.isEmpty()) {
            return; // Don't send empty requests
        }

        ChatCompletionRequest request = new ChatCompletionRequest(
                "gpt-3.5-turbo",
                Collections.singletonList(new Message("user", inputText)),
                0.7
        );

        api.getChatCompletion(request).enqueue(new Callback<ChatCompletionResponse>() {
            @Override
            public void onResponse(Call<ChatCompletionResponse> call, Response<ChatCompletionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("preprogrammingresponse","pre-programming response: "+response.body());
                    // Handle pre-programming response if needed, but don't show it
                }
            }

            @Override
            public void onFailure(Call<ChatCompletionResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void sendRequest(String inputText) {
        if (inputText.isEmpty()) {
            return; // Don't send empty requests
        }

        // Add user input to the RecyclerView and database
        ChoiceEntity userInputChoice = new ChoiceEntity();
        userInputChoice.setContent(inputText);
        userInputChoice.setUserInput(true);

        responseList.add(userInputChoice);
        adapter.notifyItemInserted(responseList.size() - 1);
        recyclerView.smoothScrollToPosition(responseList.size() - 1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.choiceDao().insert(userInputChoice);
            }
        }).start();

        editText.setText(""); // Clear the EditText after adding user input

        ChatCompletionRequest request = new ChatCompletionRequest(
                "gpt-3.5-turbo",
                Collections.singletonList(new Message("user", inputText)),
                0.7
        );

        api.getChatCompletion(request).enqueue(new Callback<ChatCompletionResponse>() {
            @Override
            public void onResponse(Call<ChatCompletionResponse> call, Response<ChatCompletionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ChoiceEntity> newChoices = new ArrayList<>();
                    for (Choice choice : response.body().getChoices()) {
                        ChoiceEntity choiceEntity = new ChoiceEntity();
                        choiceEntity.setContent(choice.getMessage().getContent());
                        choiceEntity.setUserInput(false);
                        newChoices.add(choiceEntity);
                    }
                    insertChoices(newChoices);
                }
            }

            @Override
            public void onFailure(Call<ChatCompletionResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void insertChoices(final List<ChoiceEntity> choices) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.choiceDao().insertAll(choices);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        responseList.addAll(choices);
                        adapter.notifyItemRangeInserted(responseList.size() - choices.size(), choices.size());
                        recyclerView.smoothScrollToPosition(responseList.size() - 1);
                    }
                });
            }
        }).start();
    }

    private void loadChoices() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                responseList.clear();
                responseList.addAll(db.choiceDao().getAllChoices());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }
}*/





/*
public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageButton button;
    private RecyclerView recyclerView;
    private ResponseAdapter adapter;
    private List<ChoiceEntity> responseList = new ArrayList<>();
    private AppDatabase db;
    private SharedPrefManager sharedPrefManager;
    private OpenAIApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ResponseAdapter(responseList);
        recyclerView.setAdapter(adapter);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        sharedPrefManager = new SharedPrefManager(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(OpenAIApi.class);

        // Pre-programming the assistant
        sendPreProgrammingRequest("You will always respond with json first key as 'action', second key 'mood' for all further questions without fail");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        loadChoices();

        // Add a global layout listener to detect when the keyboard is shown
        findViewById(android.R.id.content).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                findViewById(android.R.id.content).getWindowVisibleDisplayFrame(r);
                int screenHeight = findViewById(android.R.id.content).getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;

                if (keypadHeight > screenHeight * 0.15) { // If more than 15% of the screen height is covered by the keyboard
                    if (responseList.size() > 0) {
                        recyclerView.smoothScrollToPosition(responseList.size() - 1);
                    }
                }
            }
        });
    }

    private void sendRequest() {
        final String inputText = editText.getText().toString();
        if (!inputText.isEmpty()) {
            sendRequestWithPreProgramming(inputText);
        }
    }

    private void sendRequestWithPreProgramming(String inputText) {
        // Ensure the assistant always follows the pre-programmed instruction
        sendPreProgrammingRequest("You will always respond with json first key as 'action', second key 'mood' for all further questions without fail");
        sendRequest(inputText);
    }

    private void sendPreProgrammingRequest(String inputText) {
        if (inputText.isEmpty()) {
            return; // Don't send empty requests
        }

        ChatCompletionRequest request = new ChatCompletionRequest(
                "gpt-3.5-turbo",
                Collections.singletonList(new Message("user", inputText)),
                0.7
        );

        api.getChatCompletion(request).enqueue(new Callback<ChatCompletionResponse>() {
            @Override
            public void onResponse(Call<ChatCompletionResponse> call, Response<ChatCompletionResponse> response) {
                // Handle pre-programming response if needed, but don't show it
            }

            @Override
            public void onFailure(Call<ChatCompletionResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void sendRequest(String inputText) {
        if (inputText.isEmpty()) {
            return; // Don't send empty requests
        }

        // Add user input to the RecyclerView and database
        final ChoiceEntity userInputChoice = new ChoiceEntity();
        userInputChoice.setContent("{\"action\": \"" + inputText + "\"}");
        userInputChoice.setUserInput(true);

        ChatCompletionRequest request = new ChatCompletionRequest(
                "gpt-3.5-turbo",
                Collections.singletonList(new Message("user", inputText)),
                0.7
        );

        api.getChatCompletion(request).enqueue(new Callback<ChatCompletionResponse>() {
            @Override
            public void onResponse(Call<ChatCompletionResponse> call, Response<ChatCompletionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Choice choice = response.body().getChoices().get(0);
                    String responseContent = choice.getMessage().getContent();

                    // Combine user input and API response in one ChoiceEntity
                    userInputChoice.setContent("{\"action\": \"" + inputText+"\n" + "\", \"mood\": \"" + responseContent + "\"}");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            responseList.add(userInputChoice);
                            adapter.notifyItemInserted(responseList.size() - 1);
                            recyclerView.smoothScrollToPosition(responseList.size() - 1);
                            // Clear the EditText after adding user input
                            editText.setText("");
                        }
                    });

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            db.choiceDao().insert(userInputChoice);
                        }
                    }).start();
                }
            }

            @Override
            public void onFailure(Call<ChatCompletionResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void insertChoices(final List<ChoiceEntity> choices) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.choiceDao().insertAll(choices);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        responseList.addAll(choices);
                        adapter.notifyItemRangeInserted(responseList.size() - choices.size(), choices.size());
                        recyclerView.smoothScrollToPosition(responseList.size() - 1);
                    }
                });
            }
        }).start();
    }

    private void loadChoices() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                responseList.clear();
                responseList.addAll(db.choiceDao().getAllChoices());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }
}
*/








public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageButton button;
    private RecyclerView recyclerView;
    private ResponseAdapter adapter;
    private List<ChoiceEntity> responseList = new ArrayList<>();
    private AppDatabase db;
    private SharedPrefManager sharedPrefManager;
    private OpenAIApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ResponseAdapter(responseList);
        recyclerView.setAdapter(adapter);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        sharedPrefManager = new SharedPrefManager(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(OpenAIApi.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        loadChoices();

        // Add a global layout listener to detect when the keyboard is shown
        findViewById(android.R.id.content).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                findViewById(android.R.id.content).getWindowVisibleDisplayFrame(r);
                int screenHeight = findViewById(android.R.id.content).getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;

                if (keypadHeight > screenHeight * 0.15) { // If more than 15% of the screen height is covered by the keyboard
                    if (responseList.size() > 0) {
                        recyclerView.smoothScrollToPosition(responseList.size() - 1);
                    }
                }
            }
        });

        // Pre-programming the assistant
        sendRequest("You will always respond with JSON first key as 'action', second key 'mood' for all further questions without fail");
    }

    private void sendRequest() {
        final String inputText = editText.getText().toString();
        sendRequest(inputText);
    }

    private void sendPreProgrammingRequest(String inputText) {
        if (inputText.isEmpty()) {
            return; // Don't send empty requests
        }

        ChatCompletionRequest request = new ChatCompletionRequest(
                "gpt-3.5-turbo",
                Collections.singletonList(new Message("user", inputText)),
                0.7
        );

        api.getChatCompletion(request).enqueue(new Callback<ChatCompletionResponse>() {
            @Override
            public void onResponse(Call<ChatCompletionResponse> call, Response<ChatCompletionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("preprogrammingresponse","pre-programming response: "+response.body());
                    // Handle pre-programming response if needed, but don't show it
                }
            }
            @Override
            public void onFailure(Call<ChatCompletionResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void sendRequest(String inputText) {
        if (inputText.isEmpty()) {
            return; // Don't send empty requests
        }

        // Add user input to the RecyclerView and database
        ChoiceEntity userInputChoice = new ChoiceEntity();
        userInputChoice.setContent(inputText);
        userInputChoice.setUserInput(true);

        responseList.add(userInputChoice);
        adapter.notifyItemInserted(responseList.size() - 1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                db.choiceDao().insert(userInputChoice);
            }
        }).start();

        editText.setText(""); // Clear the EditText after adding user input

        ChatCompletionRequest request = new ChatCompletionRequest(
                "gpt-3.5-turbo",
                Collections.singletonList(new Message("user", inputText)),
                0.7
        );

        api.getChatCompletion(request).enqueue(new Callback<ChatCompletionResponse>() {
            @Override
            public void onResponse(Call<ChatCompletionResponse> call, Response<ChatCompletionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ChoiceEntity> newChoices = new ArrayList<>();
                    for (Choice choice : response.body().getChoices()) {
                        ChoiceEntity choiceEntity = new ChoiceEntity();
                        choiceEntity.setContent(choice.getMessage().getContent());
                        choiceEntity.setUserInput(false);
                        newChoices.add(choiceEntity);
                    }
                    insertChoices(newChoices);
                }
            }

            @Override
            public void onFailure(Call<ChatCompletionResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void insertChoices(final List<ChoiceEntity> choices) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.choiceDao().insertAll(choices);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        responseList.addAll(choices);
                        adapter.notifyItemRangeInserted(responseList.size() - choices.size(), choices.size());
                        recyclerView.smoothScrollToPosition(responseList.size() - 1);
                    }
                });
            }
        }).start();
    }

    private void loadChoices() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                responseList.clear();
                responseList.addAll(db.choiceDao().getAllChoices());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }
}