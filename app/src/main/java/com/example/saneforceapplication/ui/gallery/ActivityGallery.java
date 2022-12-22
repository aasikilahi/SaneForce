package com.example.saneforceapplication.ui.gallery;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.saneforceapplication.MainActivity;
import com.example.saneforceapplication.databinding.ActivityGalleryBinding;
import com.example.saneforceapplication.ui.gallery.adapter.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivityGallery extends AppCompatActivity {
    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    List<String> imagesEncodedList;
    private ActivityGalleryBinding binding;
    private GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnGetGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ActivityGallery.this, MainActivity.class);
        startActivity(intent);
    }

    private void imageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_MULTIPLE);
    }

       /* Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            // When an Image is picked
            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                imagesEncodedList = new ArrayList<String>();
                if (data.getData() != null) {

                    Uri mImageUri = data.getData();

                    // Get the cursor
                    Cursor cursor = getContentResolver().query(mImageUri,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imageEncoded = cursor.getString(columnIndex);
                    cursor.close();

                    ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
                    mArrayUri.add(mImageUri);
                    galleryAdapter = new GalleryAdapter(getApplicationContext(), mArrayUri);
                    binding.gridView.setAdapter(galleryAdapter);
                    binding.gridView.setVerticalSpacing(binding.gridView.getHorizontalSpacing());
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) binding.gridView
                            .getLayoutParams();
                    mlp.setMargins(0, binding.gridView.getHorizontalSpacing(), 0, 0);

                } else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();
                        ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
                        for (int i = 0; i < mClipData.getItemCount(); i++) {

                            ClipData.Item item = mClipData.getItemAt(i);
                            Uri uri = item.getUri();
                            mArrayUri.add(uri);
                            // Get the cursor
                            Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
                            // Move to first row
                            cursor.moveToFirst();

                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            imageEncoded = cursor.getString(columnIndex);
                            imagesEncodedList.add(imageEncoded);
                            cursor.close();

                            galleryAdapter = new GalleryAdapter(getApplicationContext(), mArrayUri);
                            binding.gridView.setAdapter(galleryAdapter);
                            binding.gridView.setVerticalSpacing(binding.gridView.getVerticalSpacing());
                            binding.gridView.setHorizontalSpacing(binding.gridView.getHorizontalSpacing());
                            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) binding.gridView
                                    .getLayoutParams();
                            mlp.setMargins(0, binding.gridView.getHorizontalSpacing(), 0, 0);

                        }
                        Log.v("LOG_TAG", "Selected Images" + mArrayUri.size());
                    }
                }
            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}


       /* if (resultCode == RESULT_OK) {
            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                System.out.println("^^^^^" + selectedImageUri);
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    //binding.gridView.setImageURI(selectedImageUri);
                    model = new ImageModel(selectedImageUri);
                }
            }
        }
    }*/
/*

public class ImageAdapterGridView extends BaseAdapter {
    private final Context mContext;

    public ImageAdapterGridView(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imageIDs.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mImageView;

        if (convertView == null) {
            mImageView = new ImageView(mContext);
            mImageView.setLayoutParams(new GridView.LayoutParams(130, 130));
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setPadding(16, 16, 16, 16);
        } else {
            mImageView = (ImageView) convertView;
        }
        mImageView.setImageResource(imageIDs[position]);

        // ==mImageView.setImageURI();
        return mImageView;
    }
}
}
*/
/*   final String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID};
        final String orderBy = MediaStore.Images.Media.DATE_TAKEN;
        Cursor imagecursor = managedQuery(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
                null, orderBy + " DESC");
        System.out.println("&&&&&&" + imagecursor.getCount());

     this.imageUrls = new ArrayList<String>();

        for (int i = 0; i < imagecursor.getCount(); i++) {
        imagecursor.moveToPosition(i);
        int dataColumnIndex = imagecursor.getColumnIndex(MediaStore.Images.Media.DATA);
        imageUrls.add(imagecursor.getString(dataColumnIndex));

        System.out.println("&&&&&&" + imageUrls.get(i));

    }

    options = new DisplayImageOptions.Builder()
            .showStubImage(R.drawable.stub_image)
                .showImageForEmptyUri(R.drawable.image_for_empty_url)
                .cacheInMemory()
                .cacheOnDisc()
                .build();

    imageAdapter = new ImageAdapter(getApplicationContext(), imageUrls);
       binding.gridView.setAdapter(imageAdapter);
    //gridView.setOnItemClickListener(new OnItemClickListener() {
    // @Override
    //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    // startImageGalleryActivity(position);
    // }
    //});

        binding.btnGetGallery.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //  imageChooser();
            btnChoosePhotosClick(view);
        }
    });
        *//*
 */
/*final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*//*
 */
/*
}

    public void btnChoosePhotosClick(View v) {

        ArrayList<String> selectedItems = imageAdapter.getCheckedItems();
        Toast.makeText(ActivityGallery.this, "Total photos selected: " + selectedItems.size(), Toast.LENGTH_SHORT).show();
        Log.d(GalleryFragment.class.getSimpleName(), "Selected Items: " + selectedItems);
    }

    private void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    @Override
    public void onStop() {
//        imageLoader.stop();
        super.onStop();
    }

public class ImageAdapter extends BaseAdapter {

    ArrayList<String> mList;
    LayoutInflater mInflater;
    Context mContext;
    SparseBooleanArray mSparseBooleanArray;
    CompoundButton.OnCheckedChangeListener mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // TODO Auto-generated method stub
            mSparseBooleanArray.put((Integer) buttonView.getTag(), isChecked);
        }
    };

    public ImageAdapter(Context context, ArrayList<String> imageList) {
        // TODO Auto-generated constructor stub
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mSparseBooleanArray = new SparseBooleanArray();
        mList = new ArrayList<String>();
        this.mList = imageList;

    }

    public ArrayList<String> getCheckedItems() {
        ArrayList<String> mTempArry = new ArrayList<String>();

        for (int i = 0; i < mList.size(); i++) {
            if (mSparseBooleanArray.get(i)) {
                mTempArry.add(mList.get(i));
            }
        }

        return mTempArry;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_multiphoto_item, null);
        }

        CheckBox mCheckBox = convertView.findViewById(R.id.checkBox1);
        final ImageView imageView = convertView.findViewById(R.id.imageView1);

        imageLoader.displayImage("image/" + imageUrls.get(position), imageView, options, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(Bitmap loadedImage) {
                Animation anim = AnimationUtils.loadAnimation(ActivityGallery.this, R.anim.fade_in);
                imageView.setAnimation(anim);
                anim.start();
            }
        });

        mCheckBox.setTag(position);
        mCheckBox.setChecked(mSparseBooleanArray.get(position));
        mCheckBox.setOnCheckedChangeListener(mCheckedChangeListener);

        return convertView;
    }
}
}*/
